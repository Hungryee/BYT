package calculator;

public class Main {

    public static void main(String[] args) {
        AbstractHandler chain = new AbstractHandler("") {};
        AbstractHandler end = new AbstractHandler("") {
            @Override
            public void calculate(Operation r) {

            }
        };
        AbstractHandler add = new Addition("+");
        AbstractHandler minus = new Substraction("-");
        AbstractHandler multiply = new Multiplication("*");
        AbstractHandler divide = new Division("/");
        AbstractHandler to_power = new Power("^");
        /*===========================================================*/

        chain.setNext(add);
        add.setNext(minus);
        minus.setNext(multiply);
        multiply.setNext(divide);
        divide.setNext(to_power);
        to_power.setNext(end);

        /*===========================================================*/

        Operation r = new Operation("1000-250.0");
        Operation r2 = new Operation("1731/-3.4");
        Operation r3 = new Operation("4^4");
        Operation r4 = new Operation("4096^-2");

        /*===========================================================*/
        chain.handle(r);
        chain.handle(r2);
        chain.handle(r3);
        chain.handle(r4);
    }
}
