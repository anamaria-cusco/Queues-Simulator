import controller.SimulationController;
import view.IntroView;

public class MainClass {
    public static void main(String[] args) {

        IntroView introView = new IntroView();
        new SimulationController(introView);
    }
}
