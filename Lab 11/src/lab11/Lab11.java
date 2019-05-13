package lab11;

/**
 * @version 11/15/2016
 * @author Joshu_Zicke744
 */
public class Lab11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee[] emp = new Employee[1000000];
        Employee[] tempEmp = new Employee[1000000];
        Employee[] bubbleTemp = new Employee[100000];
        Employee[] radixTemp = new Employee[1000000];
        
        for(int i = 0; i < emp.length; i++) {
            emp[i] = new Employee();
        }
        
        for(int i = 0; i < tempEmp.length; i++) {
            tempEmp[i] = emp[i];
        }
        
        for(int i = 0; i < bubbleTemp.length; i++) {
            bubbleTemp[i] = emp[i];
        }
        
        for(int i = 0; i < radixTemp.length; i++) {
            radixTemp[i] = emp[i];
        }
        
        long startTime = System.currentTimeMillis();
        NameComparator nc = new NameComparator();
        Sort.mergeSort(emp, nc);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Running time of the merge sort is: " + totalTime);
        
        startTime = System.currentTimeMillis();
        deptComparator dc = new deptComparator();
        Queue<Employee> temp1 = Sort.toQueue(emp);
        Sort.quickSort(temp1, dc);
        Sort.toArray(temp1);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Running time of the quick sort is: " + totalTime);
        
        startTime = System.currentTimeMillis();
        idComparator idc = new idComparator();
        Sort.simpleBubbleSort(bubbleTemp, idc);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Running time of the bubble sort is: " + totalTime);
        
//        startTime = System.currentTimeMillis();
//        hiredComparator hc = new hiredComparator();
//        Sort.radixSort(tempEmp, nc, idc, dc, hc);
//        endTime = System.currentTimeMillis();
//        totalTime = endTime - startTime;
//        System.out.println("Running time of the radix sort is: " + totalTime);
//        
    }

}
