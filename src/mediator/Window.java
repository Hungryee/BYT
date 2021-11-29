package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Window implements Mediator{
    public List<Component> componentList = new ArrayList<>();
    @Override
    public void event_occured(Component c, Event e) {
        switch (e){
            case CLICK:{
                if (c instanceof HidingButton){
                    if (!c.isHidden) {
                        c.hide();
                        System.out.println("Click on this " + c.toString() + " made it hidden");
                    }else{
                        System.out.println("Click on this " + c.toString() + " does nothing. It's already hidden");
                    }
                }
                if (c instanceof RecolorButton){
                    c.color = new Random().nextInt(255);
                    System.out.println("Click on this "+c.toString()+" made its color " + c.color);
                }
                if (c instanceof ResetButton){
                    for (Component other:componentList){
                        System.out.println("Click on this " + c.toString() + " made other " + other.toString() + " visible");
                        other.isHidden = false;
                    }
                }
                System.out.println("=======================");
                break;
            }
            case HOLD:{
                if (c instanceof HidingButton){
                    for (Component other:componentList) {
                        if (other!=c){
                            if (!other.isHidden) {
                                System.out.println("Hold on this " + c.toString() + " made other " + other.toString() + " hidden");
                                other.hide();
                            }
                        }
                    }
                }
                if (c instanceof ResetButton){
                    for (Component other:componentList){
                        other.color = new Random().nextInt(255);
                        System.out.println("Hold on this "+c.toString()+" made other " + other.toString() + " color  " + other.color);
                    }
                }
                System.out.println("=======================");
                break;
            }
        }
    }
}
