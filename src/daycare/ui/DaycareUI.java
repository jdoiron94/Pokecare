package daycare.ui;

import daycare.DaycareAid;
import daycare.ui.util.IntegerField;
import daycare.util.Relation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.function.Predicate;

public class DaycareUI extends JFrame {

    /**
     * Constructs the UI for the application.
     */
    public DaycareUI() {
        super("Lappy");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        addComponent(container, new JLabel("Pokémon:"), null, constraints, 0, 0);
        addComponent(container, new JLabel("Current exp:"), null, constraints, 0, 1);
        addComponent(container, new JLabel("Desired level:"), null, constraints, 0, 2);
        addComponent(container, new JLabel("Path size:"), null, constraints, 0, 3);
        JLabel lapText = new JLabel("Laps:");
        addComponent(container, lapText, null, constraints, 0, 4);
        JComboBox<String> names = new JComboBox<>(DaycareAid.nameArray());
        addComponent(container, names, null, constraints, 1, 0);
        IntegerField expField = new IntegerField(7);
        addComponent(container, expField, null, constraints, 1, 1);
        IntegerField levField = new IntegerField(3);
        addComponent(container, levField, null, constraints, 1, 2);
        IntegerField pathField = new IntegerField(3);
        addComponent(container, pathField, null, constraints, 1, 3);
        addComponent(container, new JButton("Submit"), c -> c.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Relation relation = DaycareAid.get((String) names.getSelectedItem()).relation();
                int lev = Integer.parseInt(levField.getText());
                int exp = Integer.parseInt(expField.getText());
                int pathSize = Integer.parseInt(pathField.getText());
                int laps = relation == null ? -1 : (relation.table()[lev - 1] - exp) / pathSize;
                lapText.setText("Laps: " + NumberFormat.getInstance().format(laps));
            }
        }), constraints, 1, 4);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Adds the given component to its repsective container with regards to the provided constraints.
     *
     * @param container The container.
     * @param component The component to add.
     * @param predicate The predicate to provide additional details.
     * @param constraints The constraints with which to place the component.
     * @param gridx The gridx constraint.
     * @param gridy The gridy constraint.
     */
    private void addComponent(Container container, Container component, VoidPredicate<Component> predicate, GridBagConstraints constraints,
                              int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        if (predicate != null) {
            predicate.test(component);
        }
        container.add(component, constraints);
    }

    private interface VoidPredicate<E> extends Predicate<E> {

        void act(E e);

        default boolean test(E e) {
            act(e);
            return true;
        }
    }
}
