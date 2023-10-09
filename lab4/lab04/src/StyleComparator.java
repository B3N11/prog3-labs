import java.util.Comparator;

public class StyleComparator implements Comparator<Beer>{
    public int compare(Beer o1, Beer o2) {
        return o1.getStyle().compareTo(o2.getStyle());
    }
}