package lab11;

/**
 *
 * @author Joshu_Zicke744
 */
public class hiredComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
            throw new NullPointerException("Value is null");
        }

        int adept = a.getId();
        int bhired = b.getId();

        if(adept < bhired) {
            return -1;
        }
        else if(adept > bhired) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
