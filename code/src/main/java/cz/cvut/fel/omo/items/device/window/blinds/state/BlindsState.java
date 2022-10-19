package cz.cvut.fel.omo.items.device.window.blinds.state;

import cz.cvut.fel.omo.items.device.window.blinds.WindowBlindsImpl;

public interface BlindsState {
    void rollUp(WindowBlindsImpl windowBlinds);

    void rollDown(WindowBlindsImpl windowBlinds);

    void rollMiddle(WindowBlindsImpl windowBlinds);
}
