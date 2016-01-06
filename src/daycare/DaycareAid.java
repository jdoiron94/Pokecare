package daycare;

import java.awt.EventQueue;

public class DaycareAid {

    public static void main(String... args) {
        EventQueue.invokeLater(() -> new DaycareUI().setVisible(true));
    }
}
