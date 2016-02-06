package daycare.ui.util;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class IntegerField extends JTextField {

    /**
     * Constructs an empty field for strictly integers.
     */
    public IntegerField() {
    }

    /**
     * Constructs an empty field for numbers of a specific length.
     *
     * @param columns The maximum amount of numbers in the textfield.
     */
    public IntegerField(int columns) {
        super(columns);
    }

    @Override
    protected Document createDefaultModel() {
        return new LetterFilter();
    }

    public class LetterFilter extends PlainDocument {

        @Override
        public void insertString(int offset, String string, AttributeSet set) throws BadLocationException {
            if (string != null) {
                for (char c : string.toCharArray()) {
                    try {
                        Integer.parseInt(Character.toString(c));
                    } catch (NumberFormatException ignored) {
                        return;
                    }
                }
                if (getLength() + string.length() <= getColumns()) {
                    super.insertString(offset, string, set);
                }
            }
        }
    }
}
