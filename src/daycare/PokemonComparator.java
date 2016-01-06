package daycare;

import java.util.Comparator;

public class PokemonComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        return o1.name().compareTo(o2.name());
    }
}
