package cz.cvut.fel.omo.items.device.window.blinds.state;

import cz.cvut.fel.omo.items.device.window.blinds.WindowBlindsImpl;

public class RolledMiddleState implements BlindsState{
    @Override
    public void rollUp(WindowBlindsImpl windowBlinds) {
        windowBlinds.setState(new RolledUpState());
    }

    @Override
    public void rollDown(WindowBlindsImpl windowBlinds) {
        windowBlinds.setState(new RolledDownState());
    }

    @Override
    public void rollMiddle(WindowBlindsImpl windowBlinds) {
        System.out.println("blinds are rolled in the middle");
    }

}
