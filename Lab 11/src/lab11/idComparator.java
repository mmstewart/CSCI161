package lab11;

/**
 *
 * @author Joshu_Zicke744
 */
public class idComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
            throw new NullPointerException("Value is null");
        }

        int aid = a.getId();
        int bid = b.getId();

        if(aid < bid) {
            return -1;
        }
        else if(aid > bid) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
