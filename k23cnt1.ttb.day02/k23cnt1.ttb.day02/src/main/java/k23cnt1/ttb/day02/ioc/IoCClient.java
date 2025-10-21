package k23cnt1.ttb.day02.ioc;

public class IoCClient {
    private IoCService iocService;

    // ✅ Dùng Dependency Injection qua constructor
    public IoCClient(IoCService service) {
        this.iocService = service;
    }

    public void doSomething() {
        iocService.serve();
    }
}
