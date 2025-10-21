package k23cnt1.ttb.day02;

import java.util.Arrays;

public class TightCouplingService {
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public TightCouplingService() {
    }

    public TightCouplingService(BubbleSortAlgorithm bubbleSortAlgorithm) {
        this.bubbleSortAlgorithm = bubbleSortAlgorithm;
    }

    public void complexBusinessSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TightCouplingService tcCouplingService = new TightCouplingService();
        int[] arr = {5, 2, 8, 1, 9};
        tcCouplingService.complexBusinessSort(arr);
    }
}
