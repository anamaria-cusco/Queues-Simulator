package model;

import utils.LogFile;
import view.SimulationFrame;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.Semaphore;


public class Producer extends Thread {
    protected static Semaphore semaphore= new Semaphore(0);
    private final SimulationFrame simulationFrame;
    private final int simulationTime;
    private List<Client> clientsList;
    private List<Consumer> consumers;
    private int simulationCnt;
    private int peekHour=0;
    private float averageServiceTime=0;
    private float averageWaitingTime=0;
    private int maxNoOfClients=0;
    private int noOfClients=0;


    public Producer(int simulationTime,int noOfQueues) {
        this.simulationTime = simulationTime;
        this.simulationFrame=new SimulationFrame(noOfQueues,simulationTime);

    }

    public void generateClients(int noOfClients, int minArrivalTime, int maxArrivalTime, int minServiceTime, int maxServiceTime) {
        this.noOfClients=noOfClients;
        Random random = new Random();
        int clientID = 1;
        clientsList = new ArrayList<>();
        for (int i = 0; i < noOfClients; i++) {
            int serviceTime=random.nextInt(maxServiceTime - minServiceTime + 1) + minServiceTime;
            clientsList.add(new Client(clientID++, random.nextInt(maxArrivalTime - minArrivalTime + 1) + minArrivalTime,serviceTime));
            averageServiceTime+=serviceTime;
        }
        averageServiceTime=averageServiceTime/noOfClients;
        Collections.sort(clientsList, Comparator.comparing(Client::getArrivalTime));

    }

    public void generateConsumers(int noOfConsumers) {
        consumers = new ArrayList<>();
        for (int i = 0; i < noOfConsumers; i++) {
            consumers.add(new Consumer(true));
        }

        for (int i = 0; i < noOfConsumers; i++) {
            consumers.get(i).start();
        }

    }

    public void computePeekHour(){
        int maxNumberOfClientsAtMoment=0;
        for (int i = 0; i < consumers.size(); i++) {
            int numberOfClients=consumers.get(i).getClients().size();
            maxNumberOfClientsAtMoment+=numberOfClients;
        }
        if(maxNumberOfClientsAtMoment>maxNoOfClients)
        {
            maxNoOfClients=maxNumberOfClientsAtMoment;
            peekHour=simulationCnt;
        }

    }

    public int getMinWaitingTimeQueue() {
        int minWaitingTime = Integer.MAX_VALUE;
        int queueNo = 0;

        for (int i = 0; i < consumers.size(); i++) {
            int minP = consumers.get(i).getWaitingTime();
            if (minP < minWaitingTime) {
                minWaitingTime = minP;
                queueNo = i;

            }
        }
        return queueNo;
    }

    public void stopSimulation(){
        for (int i = 0; i < consumers.size(); i++) {
            consumers.get(i).running=false;
        }

    }

    public void printQueues()
    {
        for (int i = 0; i < consumers.size(); i++) {
            System.out.println("Queue "+i);
            consumers.get(i).print();
        }
    }

    public void computeAverageWaitingTime()
    {
        for (int i = 0; i < consumers.size(); i++) {
            averageWaitingTime+=consumers.get(i).totalWaitingTime;
        }
        averageWaitingTime=averageWaitingTime/noOfClients;
    }

    public boolean areEmptyQueues(){
        for(int i=0;i<consumers.size();i++){
            if (!consumers.get(i).getClients().isEmpty()){
                return false;
            }
        }
        return true;
    }


    @Override
    public void run() {
            simulationCnt = 0;

            while (simulationCnt <= simulationTime) {
                //System.out.println("Simulation count:"+simulationCnt);
                    while (clientsList.size() > 0 && clientsList.get(0).arrivalTime == simulationCnt) {
                        Client c = clientsList.remove(0);
                        consumers.get(getMinWaitingTimeQueue()).addClient(c);
                        computePeekHour();
                    }


                    simulationFrame.updateFrame(consumers,simulationCnt);
                    LogFile.updateLog(consumers,clientsList,simulationCnt);

                    if(areEmptyQueues() && clientsList.isEmpty()) break;
                    semaphore.release(consumers.size());

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                    // printQueues();
                simulationCnt++;

            }
        this.stopSimulation();
        computeAverageWaitingTime();
        LogFile.statisticLog(peekHour,averageWaitingTime,averageServiceTime);
        JOptionPane.showMessageDialog(simulationFrame,"Peak Hour: "+peekHour
                                                        +"\nAverage Waiting Time:"+averageWaitingTime
                                                        +"\nAverage Service Time:"+averageServiceTime);
    }

}


