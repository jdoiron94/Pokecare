package daycare;

import daycare.ui.DaycareUI;
import daycare.util.Crawler;
import daycare.util.OperatingSystem;

import javax.swing.*;
import java.awt.EventQueue;
import java.util.Set;
import java.util.TreeSet;

public class DaycareAid {

    private static final Set<Pokemon> pokemon = new TreeSet<>();
    private static final Set<String> names = new TreeSet<>();

    /**
     * Adds a name to the set.
     *
     * @param name The name.
     */
    public static void add(String name) {
        names.add(name);
    }

    /**
     * Adds all pokemon to the set.
     *
     * @param pokemon The pokemon.
     */
    public static void addAll(Set<Pokemon> pokemon) {
        DaycareAid.pokemon.addAll(pokemon);
    }

    /**
     * Finds a given Pokemon in the set.
     *
     * @param name The name of the Pokemon.
     * @return The Pokemon.
     */
    public static Pokemon get(String name) {
        return pokemon.stream().filter(p -> p.name().equals(name)).findFirst().orElse(null);
    }

    /**
     * @return The array of Pokemon names.
     */
    public static String[] nameArray() {
        return names.toArray(new String[names.size()]);
    }

    /**
     * Runs the program.
     *
     * @param args Command line arguments.
     */
    public static void main(String... args) {
        Crawler.execute();
        if (OperatingSystem.getSystem() == OperatingSystem.MAC) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        } else {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                System.err.println("Could not set system look and feel.");
            }
        }
        EventQueue.invokeLater(() -> {
            DaycareUI ui = new DaycareUI();
            ui.setVisible(true);
        });
    }
}
