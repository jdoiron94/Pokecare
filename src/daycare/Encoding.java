package daycare;

/**
 * @author Jacob Doiron
 * @since 1/5/2016
 */
public enum Encoding {

    SINGLE_QUOTE("%27", "'"),
    ACUTE_E("%C3%A9", "é");

    private final String decoded;
    private final String encoded;

    Encoding(String decoded, String encoded) {
        this.decoded = decoded;
        this.encoded = encoded;
    }

    /**
     * @return The decoded string.
     */
    public String decoded() {
        return decoded;
    }

    /**
     * @return The encoded string.
     */
    public String encoded() {
        return encoded;
    }
}
