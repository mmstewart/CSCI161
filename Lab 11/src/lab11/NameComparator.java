package lab11;

/**
 *
 * @author Joshu_Zicke744
 */
public class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
            throw new NullPointerException("Value is null");
        }

        String an = a.getName();
        String bn = b.getName();

        return an.compareTo(bn);
    }

}
