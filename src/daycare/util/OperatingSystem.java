package daycare.util;

/**
 * @author Jacob Doiron
 * @since 1/6/2016
 */
public enum OperatingSystem {

    WINDOWS,
    LINUX,
    MAC,
    OTHER;

    /**
     * Gets the user's running operating system.
     *
     * @return If found, the <t>OperatingSystem</t> enum representing the os the user is running; otherwise, <t>OTHER</t>;
     */
    public static OperatingSystem getSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        for (OperatingSystem o : values()) {
            if (os.contains(o.toString().toLowerCase())) {
                return o;
            }
        }
        return OTHER;
    }
}