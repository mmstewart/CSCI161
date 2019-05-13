package lab11;

import java.util.Arrays;

/**
 *
 * @author Joshu_Zicke744
 */
public class Sort {
    
    public static <K> void simpleBubbleSort(K[] data, Comparator<K> comp) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comp.compare(data[j], data[j + 1]) <= 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
    
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0;
        int j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }
    
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        merge(S1, S2, S, comp);
    }
    
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if(n < 2) return;
        K pivot = S.first();
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while(!S.isEmpty()) {
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if(c < 0) {
                L.enqueue(element);
            }
            else if(c == 0) {
                E.enqueue(element);
            }
            else {
                G.enqueue(element);
            }
        }
        quickSort(L, comp);
        quickSort(G, comp);
        while(!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while(!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while(!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }
    
    public static <K> Queue toQueue(K[] array) {
        LinkedQueue lq = new LinkedQueue();
        for(int i =0; i < array.length; i++) {
            lq.enqueue(array[i]);
        }
        return lq;
    }
    
    public static <K> K[] toArray(Queue<K> queue) {
        K[] array = (K[]) new Object[queue.size()];
        for(int i = 0; i < array.length; i++) {
            array[i] = queue.dequeue();
        }
        return array;
    }
    
    public static <K> void radixSort(K[] S, Comparator<K> nc, Comparator<K> idc, Comparator<K> dc, Comparator<K> hc) {
        Sort.mergeSort(S, nc);
        Sort.mergeSort(S, idc);
        Sort.mergeSort(S, dc);
        Sort.mergeSort(S, hc);
    }
}
