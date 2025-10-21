package k23cnt1.ttb.day02.ioc;

public class IoCWithDI {
    public static void main(String[] args) {
        // ✅ Tạo đối tượng Service và inject (truyền vào) Client
        IoCService service = new IoCService();
        IoCClient client = new IoCClient(service);

        client.doSomething();
    }
}
