package k23cnt1.ttb.day02;

public class LooselyCoupledService {

    // Dependency: Nó cần một SortAlgorithm
    private SortAlgorithm sortAlgorithm;

    // Dependency Injection qua Constructor
    public LooselyCoupledService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    // Business Method
    public void complexBusiness(int[] array) {
        System.out.println("Starting complex business...");

        // Sử dụng dependency để thực hiện việc sắp xếp
        sortAlgorithm.sort(array);

        System.out.println("Complex business finished.");
    }

    // Main method để chạy ứng dụng (Manual Wiring)
    public static void main(String[] args) {
        // 1. Tạo Dependency (Component)
        LooselyBubbleSortAlgorithm bubbleSortAlgorithm = new LooselyBubbleSortAlgorithm();

        // 2. Inject Dependency vào Service
        LooselyCoupledService service = new LooselyCoupledService(bubbleSortAlgorithm);

        // 3. Thực thi
        int[] data = {11, 21, 13, 42, 15};
        service.complexBusiness(data);
    }
}