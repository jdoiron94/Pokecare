package daycare;

import java.awt.EventQueue;

public class DaycareAid {

    /**
     * Runs the program.
     *
     * @param args Command line arguments.
     */
    public static void main(String... args) {
        EventQueue.invokeLater(() -> new DaycareUI().setVisible(true));
    }
}
