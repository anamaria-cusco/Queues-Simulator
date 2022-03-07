package view;



import model.Client;
import model.Consumer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SimulationFrame extends JFrame {
        JFrame frame;
        JPanel panel, labelsPanel, topPanel;
        JLabel label;
        JTextField textField;
        JLabel simulationLabel;
        ArrayList<JLabel> labelsArray = new ArrayList<>();
        ArrayList<JTextField> textFieldsArray = new ArrayList<>();
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border border = BorderFactory.createLineBorder(Color.black);
        JScrollPane labelsScroll;
        public SimulationFrame(int noOfQueues, int currentTime) {

                        frame = new JFrame();
                        panel = new JPanel(new BorderLayout());

                        for (int i = 0; i < noOfQueues; i++) {
                            label=new JLabel("Queue "+(i+1)+":");
                            label.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
                            label.setOpaque(true);
                            label.setBackground(new Color(207,238,250));
                            label.setFont(new Font("Dialog", Font.PLAIN,24));
                            labelsArray.add(label);

                            textField=new JTextField("closed",50);
                            textField.setOpaque(true);
                            textField.setEditable(false);
                            textField.setFont(new Font("Dialog", Font.PLAIN,24));
                            textField.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
                            textFieldsArray.add(textField);

                        }

                        labelsPanel = new JPanel(new GridBagLayout());
                        labelsPanel.setBackground(new Color(162,177,215));
                        listLabels(noOfQueues);

                        topPanel = new JPanel(new GridBagLayout());
                        GridBagConstraints c = new GridBagConstraints();
                        topPanel.setBackground(new Color(207,238,250));

                        simulationLabel=new JLabel("Simulation in progress...    Time: "+currentTime);
                        simulationLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.weightx = 10;
                        topPanel.add(simulationLabel, c);


                        panel.add(topPanel, BorderLayout.NORTH);
                        panel.add(labelsScroll, BorderLayout.CENTER);
                        frame.add(panel);
                        frame.setSize(800, 800);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }



                public void listLabels (int noOfQueues) {
                    // Create constraints
                    GridBagConstraints textFieldConstraints = new GridBagConstraints();
                    GridBagConstraints labelConstraints = new GridBagConstraints();



                        labelsScroll = new JScrollPane(labelsPanel);
                        for (int i=0;i<noOfQueues;i++) {

                            // constrangerile text-field-urilor
                            textFieldConstraints.gridx = 0;
                            textFieldConstraints.gridy = i;

                            // constrangerile label-urilor
                            labelConstraints.gridx = 1;
                            labelConstraints.gridy = i;

                            // adaugam componentele in panel
                            labelsPanel.add(labelsArray.get(i), textFieldConstraints);
                            labelsPanel.add(textFieldsArray.get(i), labelConstraints);

                        }
                }

                public void updateFrame(List<Consumer> consumers, int currentTime){
                        simulationLabel.setText("Simulation in progress...    Time: "+currentTime);
                        for(int i=0;i<consumers.size();i++){
                            String str="";
                            if(consumers.get(i).getClients().isEmpty())
                                str="empty";
                            else {
                                for (int j = 0; j < consumers.get(i).getClients().size(); j++) {
                                    str += "\uD83D\uDC64";
                                }
                            }
                            textFieldsArray.get(i).setText(str);
                        }
                }

}












