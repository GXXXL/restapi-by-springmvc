package exception;

public class DemoObjectNotFoundException extends RuntimeException {
    public DemoObjectNotFoundException(long demoObjectId) {
        this.demoObjectId = demoObjectId;
    }

    public long getDemoObjectId() {
        return demoObjectId;
    }

    public void setDemoObjectId(long demoObjectId) {
        this.demoObjectId = demoObjectId;
    }

    private long demoObjectId;
}
