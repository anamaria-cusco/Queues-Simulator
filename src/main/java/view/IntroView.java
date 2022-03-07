package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class IntroView extends JFrame {


    private final JTextField noOfClientsTextField;
    private final JTextField noOfQueuesTextField;
    private final JTextField simulationIntervalTextField;
    private final JTextField minArrivalTimeTextField;
    private final JTextField maxArrivalTimeTextField;
    private final JTextField minServiceTimeTextField;
    private final JTextField maxServiceTimeTextField;
    private final JButton startSimulationButton;

    public IntroView(){


        JPanel contentPanel=new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(162,177,215));


        JLabel applicationTitle=new JLabel("Queues Simulator");
        applicationTitle.setFont(new Font("Hello Sans",Font.BOLD,32));
        applicationTitle.setBounds(220,0,400,50);


        noOfClientsTextField=new JTextField(10);
        noOfQueuesTextField=new JTextField(10);
        simulationIntervalTextField=new JTextField(10);
        minArrivalTimeTextField=new JTextField(10);
        maxArrivalTimeTextField=new JTextField(10);
        minServiceTimeTextField=new JTextField(10);
        maxServiceTimeTextField=new JTextField(10);
        JLabel noOfClientsLabel=new JLabel("Numar de clienti:");
        noOfClientsLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
        noOfClientsLabel.setBounds(80,90,300,30);
        noOfClientsTextField.setBounds(400,90,100,30);
        noOfClientsTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        noOfClientsTextField.setBackground(new Color(207,238,250));


        JLabel noOfQueuesLabel=new JLabel("Numar de cozi:");
        noOfQueuesLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
        noOfQueuesLabel.setBounds(80,130,300,30);
        noOfQueuesTextField.setBounds(400,130,100,30);
        noOfQueuesTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        noOfQueuesTextField.setBackground(new Color(207,238,250));


        JLabel simulationIntervalLabel=new JLabel("Durata simularii:");
        simulationIntervalLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
        simulationIntervalLabel.setBounds(80,170,300,30);
        simulationIntervalTextField.setBounds(400,170,100,30);
        simulationIntervalTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        simulationIntervalTextField.setBackground(new Color(207,238,250));


        JLabel arrivalTimeIntervalLabel=new JLabel("Intervalul timpului de sosire:");
        arrivalTimeIntervalLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
        arrivalTimeIntervalLabel.setBounds(80,210,300,30);
        minArrivalTimeTextField.setBounds(400,210,100,30);
        maxArrivalTimeTextField.setBounds(520,210,100,30);
        minArrivalTimeTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        minArrivalTimeTextField.setBackground(new Color(207,238,250));
        maxArrivalTimeTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        maxArrivalTimeTextField.setBackground(new Color(207,238,250));


        JLabel serviceTimeIntervalLabel=new JLabel("Intervalul timpului de servire:");
        serviceTimeIntervalLabel.setFont(new Font("Times New Roman", Font.PLAIN,24));
        serviceTimeIntervalLabel.setBounds(80,250,300,30);
        minServiceTimeTextField.setBounds(400,250,100,30);
        maxServiceTimeTextField.setBounds(520,250,100,30);
        minServiceTimeTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        minServiceTimeTextField.setBackground(new Color(207,238,250));
        maxServiceTimeTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        maxServiceTimeTextField.setBackground(new Color(207,238,250));


        startSimulationButton=new JButton("Start Simulare!",new ImageIcon("src/main/java/view/icons/startIcon.png"));
        startSimulationButton.setFont(new Font("Times New Roman", Font.PLAIN,24));
        startSimulationButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        startSimulationButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startSimulationButton.setBackground(new Color(207,238,250));
        startSimulationButton.setBounds(100,300,500,250);


        contentPanel.add(applicationTitle);
        contentPanel.add(noOfClientsLabel);
        contentPanel.add(noOfClientsTextField);
        contentPanel.add(noOfQueuesLabel);
        contentPanel.add(noOfQueuesTextField);

        contentPanel.add(simulationIntervalLabel);
        contentPanel.add(simulationIntervalTextField);

        contentPanel.add(arrivalTimeIntervalLabel);
        contentPanel.add(minArrivalTimeTextField);
        contentPanel.add(maxArrivalTimeTextField);

        contentPanel.add(serviceTimeIntervalLabel);
        contentPanel.add(minServiceTimeTextField);
        contentPanel.add(maxServiceTimeTextField);
        contentPanel.add(startSimulationButton);


        this.setContentPane(contentPanel);
        this.setSize(700,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public String getNoOfClientsTextField() {
        return noOfClientsTextField.getText();
    }

    public String getNoOfQueuesTextField() {
        return noOfQueuesTextField.getText();
    }

    public String getSimulationIntervalTextField() {
        return simulationIntervalTextField.getText();
    }

    public String getMinArrivalTimeTextField() {
        return minArrivalTimeTextField.getText();
    }

    public String getMaxArrivalTimeTextField() {
        return maxArrivalTimeTextField.getText();
    }

    public String getMinServiceTimeTextField() {
        return minServiceTimeTextField.getText();
    }

    public String getMaxServiceTimeTextField() {
        return maxServiceTimeTextField.getText();
    }

    public void addStartSimulationListener(ActionListener a){
        startSimulationButton.addActionListener(a);
    }




}
