package daycare;

public class Pokemon implements Comparable<Pokemon> {

    private final String name;
    private final Relation relation;

    /**
     * Constructs a Pokemon.
     *
     * @param name The Pokemon's name.
     * @param relation The Pokemon's exp relation.
     */
    public Pokemon(String name, Relation relation) {
        this.name = name;
        this.relation = relation;
    }

    /**
     * @return The Pokemon's name.
     */
    public String name() {
        return name;
    }

    /**
     * @return The Pokemon's relation.
     */
    public Relation relation() {
        return relation;
    }

    @Override
    public int compareTo(Pokemon o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pokemon) {
            Pokemon p = (Pokemon) o;
            return name.equals(p.name) && relation == p.relation;
        }
        return false;
    }

    @Override
    public String toString() {
        return "new Pokemon(\"" + name + "\", " + relation.getName() + ")";
    }
}
