package mediator;

public class Component {
    public int id;
    public static int ID = 1;
    int color;
    Window mediator;
    boolean isHidden = false;
    public Component(Window m){
        this.mediator = m;
        m.componentList.add(this);
        id = ID++;
    }
    public void hide(){
        isHidden = true;
        //...
    }

    @Override
    public String toString() {
        return "Button #" + id;
    }
}
class RecolorButton extends Component{
    public RecolorButton(Window m) {
        super(m);
    }
    public void click(){
        this.mediator.event_occured(this,Event.CLICK);
    }

}
class HidingButton extends Component{
    public HidingButton(Window m) {
        super(m);
    }

    public void click(){
        this.mediator.event_occured(this,Event.CLICK);
    }
    public void hold(){
        this.mediator.event_occured(this,Event.HOLD);
    }
}
class ResetButton extends Component{
    public ResetButton(Window m) {
        super(m);
    }

    public void click(){
        this.mediator.event_occured(this,Event.CLICK);
    }
    public void hold(){
        this.mediator.event_occured(this,Event.HOLD);
    }
}


