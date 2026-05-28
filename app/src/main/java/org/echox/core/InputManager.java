package org.echox.core;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.glfwGetKey;

public class InputManager {
    
    private long window;

    public InputManager(long window) {
        this.window = window;
    }

    /*
    for later: frame-to-frame state tracking
    pressed this frame
    released this frame
    held
    mouse delta
    scroll data
    double click
    action mappin
     */
    public void update() {

    }

    public boolean isKeyPressed(int key) {
        return glfwGetKey(window, key) == GLFW_PRESS;
    }
    
}
