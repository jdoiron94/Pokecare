package daycare;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.text.NumberFormat;

public class DaycareUI extends JFrame {

    /**
     * Constructs the UI for the application.
     */
    public DaycareUI() {
        setTitle("Lappy");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Box left = Box.createVerticalBox();
        Box right = Box.createVerticalBox();
        JLabel pokemon = new JLabel("Pokémon:");
        left.add(Box.createVerticalGlue());
        add(pokemon, left);
        left.add(Box.createVerticalGlue());
        final JComboBox<String> pokemonList = new JComboBox<>(DaycareAid.nameArray());
        right.add(Box.createVerticalGlue());
        add(pokemonList, right);
        right.add(Box.createVerticalGlue());
        JLabel experience = new JLabel("Experience:");
        add(experience, left);
        left.add(Box.createVerticalGlue());
        final IntegerField experienceField = new IntegerField();
        add(experienceField, right);
        right.add(Box.createVerticalGlue());
        JLabel level = new JLabel("Level:");
        add(level, left);
        left.add(Box.createVerticalGlue());
        final JSpinner levelSpinner = new JSpinner(new SpinnerNumberModel(99, 1, 99, 1));
        levelSpinner.setEditor(new JSpinner.DefaultEditor(levelSpinner));
        ((JSpinner.DefaultEditor) levelSpinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.RIGHT);
        add(levelSpinner, right);
        right.add(Box.createVerticalGlue());
        JLabel path = new JLabel("Path Size:");
        add(path, left);
        left.add(Box.createVerticalGlue());
        final IntegerField pathField = new IntegerField();
        add(pathField, right);
        right.add(Box.createVerticalGlue());
        JButton submit = new JButton("Submit");
        final JLabel laps = new JLabel("#### laps");
        submit.addActionListener(event -> {
            Relation relation = DaycareAid.get((String) pokemonList.getSelectedItem()).relation();
            int lev = (Integer) levelSpinner.getValue();
            int exp = Integer.parseInt(experienceField.getText());
            int pathSize = Integer.parseInt(pathField.getText());
            int lapz = relation == null ? -1 : (relation.table()[lev - 1] - exp) / pathSize;
            laps.setText(NumberFormat.getInstance().format(lapz) + (lapz == 1 ? " lap" : " laps"));
        });
        add(submit, left);
        add(laps, right);
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Adds a component to a specified container.
     *
     * @param component The component.
     * @param container The container.
     */
    private void add(JComponent component, Container container) {
        component.setPreferredSize(new Dimension(component.getPreferredSize().width, 20));
        container.add(component);
    }
}
