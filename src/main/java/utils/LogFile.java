package utils;

import model.Client;
import model.Consumer;

import java.io.*;
import java.util.List;

public class LogFile {

    public static void updateLog(List<Consumer> consumers, List<Client> clientsList, int currentTime)  {

            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;

            try {
                fw = new FileWriter("LogOfEvents.txt", true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);

                pw.println("Time " + currentTime);
                pw.print("Waiting clients:");
                for(Client c: clientsList){
                    pw.print(c.toString());
                }
                pw.println();

                for(int i=0;i<consumers.size();i++){
                    pw.print("Queue "+(i+1)+":");
                    if(consumers.get(i).getClients().isEmpty())
                        pw.print("empty\n");
                    else{
                        for(Client c: consumers.get(i).getClients()){
                            pw.print(c.toString());
                        }
                        pw.println();
                    }
                }
                pw.println();
                pw.flush();

            } catch(IOException e) { e.printStackTrace(); }
            finally
             {
                try {
                    pw.close();
                    bw.close();
                    fw.close();
                } catch (IOException io) {// can't do anything }
                }

            }
        }


    public static void statisticLog(int peakHour, float avgWaitingTime, float avgServiceTime) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("LogOfEvents.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println("\nStatistics:");
            pw.println("Peak Hour: " + peakHour);
            pw.println("Average Waiting Time: " + avgWaitingTime);
            pw.println("Average Service Time: " + avgServiceTime);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything
            }

        }
    }

}



