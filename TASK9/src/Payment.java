public class Payment {
    private int uuid;
    private String account_num;
    private Subscription owner;
    private PaymentStatus status;

    public Payment(int uuid, String account_num, Subscription owner) {
        this.uuid = uuid;
        this.account_num = account_num;
        this.owner = owner;
        this.status = null;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public Subscription getOwner() {
        return owner;
    }

    public void setOwner(Subscription owner) {
        this.owner = owner;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public enum PaymentStatus{
        FAILED,
        IN_PROGRESS,
        SUCCESSFULL
    }
}
