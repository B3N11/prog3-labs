import java.util.Comparator;

public class StrengthComparator implements Comparator<Beer>{
    public int compare(Beer o1, Beer o2) {
        return o1.getStrength() - o2.getStrength() > 0 ? 1 : o1.getStrength() - o2.getStrength() == 0 ? 0 : -1;
    }
}