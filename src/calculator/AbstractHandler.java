package calculator;

public abstract class AbstractHandler {
    AbstractHandler next;
    String actionAccepted;
    public AbstractHandler(String s){
        this.actionAccepted = s;
    }

    public void handle(Operation r) {
        if (r.getAction().equals(actionAccepted)){
            this.calculate(r);
        }else{
            if (next!=null) this.next.handle(r);
        }
    }


    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public void calculate(Operation r){

    }
}
