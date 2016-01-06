package daycare;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Crawler {

    public static void main(String... args) {
        String base = "http://bulbapedia.bulbagarden.net/w/index.php?title=Category:Pok%C3%A9mon_in_the_";
        String end = "_experience_group";
        String[] suffixes = {"Erratic", "Fast", "Medium_Fast", "Medium_Fast", "Medium_Slow", "Slow", "Fluctuating"};
        Set<Pokemon> pokemon = new TreeSet<>(new PokemonComparator());
        try {
            for (int i = 0; i < suffixes.length; i++) {
                URL url = new URL(base + suffixes[i] + (i != 3 ? end : end + "&pagefrom=Primeape"));
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while ((line = reader.readLine()) != null && !line.contains("printfooter")) {
                    if (line.contains("(Pokémon)")) {
                        String split = line.split("/wiki/")[1].split("_")[0];
                        int index = i >= 3 ? i - 1 : i;
                        for (Encoding e : Encoding.values()) {
                            split = split.replaceAll(e.decoded(), e.encoded());
                        }
                        pokemon.add(new Pokemon(split, Relation.values()[index]));
                    }
                }
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote: " + pokemon.size() + ": " + Arrays.toString(pokemon.toArray()));
        System.out.println("Local: " + Holder.pokemon.length);
    }
}
