package pool;

public interface Reusable {
    public void onRelease();
    public void onAcquire();
}
