package lab11;

/**
 *
 * @author Joshu_Zicke744
 */
public class deptComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
            throw new NullPointerException("Value is null");
        }

        int adept = a.getDept();
        int bdept = b.getDept();

        if(adept< bdept) {
            return -1;
        }
        else if(adept > bdept) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
