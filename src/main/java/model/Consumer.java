package model;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer extends Thread {
    private BlockingQueue<Client> clients;
    protected boolean running;
    protected int totalWaitingTime=0;
    private int waitTimeAux;

    public Consumer(boolean running) {
        this.clients = new LinkedBlockingDeque<>();
        this.running = running;

    }

    public void addClient(Client client) {
        totalWaitingTime+=waitTimeAux;
        clients.add(client);
    }

    public void removeClient()  {

        try {
            clients.take();
        }catch(InterruptedException e){ }
    }

    public int getWaitingTime() {
        int waitingTime = 0;
        for (Client c : clients) {
            waitingTime += c.serviceTime;
        }
        waitTimeAux=waitingTime;
        return waitingTime;
    }

    @Override
    public void run() {

        while (running) {

                if (clients.size() > 0) {
                    Client c=clients.element();
                    if(c.serviceTime>1){
                        c.serviceTime--;
                    }
                    else{
                        removeClient();
                    }
                }

            try { sleep(1000); } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Producer.semaphore.acquire(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public BlockingQueue<Client> getClients() {
        return clients;
    }

    public void setClients(BlockingQueue<Client> clients) {
        this.clients = clients;
    }


    public void print(){
        System.out.println(clients);
    }

}
