package k23cnt1.ttb.day02.ioc;

public class Client {
    private Service service;

    public Client() {
        // Client tự tạo đối tượng Service (chưa dùng IoC)
        service = new Service();
    }

    public void doSomething() {
        service.serve();
    }
}
