package cz.cvut.fel.omo.items.device.window.blinds.state;

import cz.cvut.fel.omo.items.device.window.blinds.WindowBlindsImpl;

public class RolledDownState implements BlindsState{
    @Override
    public void rollUp(WindowBlindsImpl windowBlinds) {
        windowBlinds.setState(new RolledUpState());
    }

    @Override
    public void rollDown(WindowBlindsImpl windowBlinds) {
        System.out.println("Blinds are rolled down");
    }

    @Override
    public void rollMiddle(WindowBlindsImpl windowBlinds) {
        windowBlinds.setState(new RolledMiddleState());
    }

}
