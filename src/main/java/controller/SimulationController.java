package controller;

import model.Producer;
import view.ErrorView;
import view.IntroView;
import view.SimulationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationController {

    public IntroView introView;
    public Producer producer;

    public SimulationController(IntroView introView) {
        this.introView = introView;
        introView.addStartSimulationListener(new StartSimulationListener());
    }

    class StartSimulationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                producer = new Producer(Integer.parseInt(introView.getSimulationIntervalTextField()),Integer.parseInt(introView.getNoOfQueuesTextField()));
                producer.generateClients(Integer.parseInt(introView.getNoOfClientsTextField()), Integer.parseInt(introView.getMinArrivalTimeTextField()), Integer.parseInt(introView.getMaxArrivalTimeTextField()),
                        Integer.parseInt(introView.getMinServiceTimeTextField()), Integer.parseInt(introView.getMaxServiceTimeTextField()));
                producer.generateConsumers(Integer.parseInt(introView.getNoOfQueuesTextField()));
                producer.start();
            } catch (Exception ex) {
                new ErrorView("Asigurati-va ca datele introduse sunt corecte!");
            }

        }
    }
}






