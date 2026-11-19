import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Quicksort {

    static Random rand = new Random();

    public static void randomInit(ArrayList<Integer> input, int size) {
        input.clear();
        for (int i = 0; i < size; i++) {
            input.add(rand.nextInt(size * 10));
        }
    }

    public static void echanger(ArrayList<Integer> liste, int i, int j) {
        int tmp = liste.get(i);
        liste.set(i, liste.get(j));
        liste.set(j, tmp);
    }

    public static int partitionner(ArrayList<Integer> liste, int debut, int fin) {
        int pivot = liste.get(fin);
        int i = debut - 1;
        for (int j = debut; j < fin; j++) {
            if (liste.get(j) <= pivot) {
                i++;
                echanger(liste, i, j);
            }
        }
        echanger(liste, i + 1, fin);
        return i + 1;
    }

    // quicksort classique
    public static void quicksort(ArrayList<Integer> liste, int debut, int fin) {
        if (debut < fin) {
            int p = partitionner(liste, debut, fin);
            quicksort(liste, debut, p - 1);
            quicksort(liste, p + 1, fin);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        randomInit(test, 10);
        System.out.println(test);
        quicksort(test, 0, test.size() - 1);
        System.out.println(test);
    }
}
