import java.util.Date;

public class Subscription {
    private int uuid;
    private User user;
    private int plan;
    private Date date_from;
    public Payment payment;

    public Subscription(int uuid, User user, int plan, Date date_from) {
        this.uuid = uuid;
        this.user = user;
        this.plan = plan;
        this.date_from = date_from;
    }

    public Subscription createSubscription(){
        //...
        return null;
    }
    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
