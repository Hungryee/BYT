package mediator;

public class Main {
    public static void main(String[] args) {
        Window w = new Window();

        HidingButton hb = new HidingButton(w);
        HidingButton hb1 = new HidingButton(w);
        HidingButton hb2 = new HidingButton(w);
        RecolorButton rb = new RecolorButton(w);
        ResetButton reset = new ResetButton(w);

        hb.click();

        hb1.hold();
        hb2.click();
        rb.click();

        rb.click();

        reset.click();
        reset.hold();
    }
}
