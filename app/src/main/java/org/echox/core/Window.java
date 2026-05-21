package org.echox.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Window {

    private long window;
    double delta_time;

    public Window(String title, int width, int height) {

        if (!glfwInit()) {
            throw new IllegalStateException("GLFW failed to initialize");
        }

        window = glfwCreateWindow(width, height, title, 0, 0);

        if (window == 0) {
            throw new RuntimeException("Failed to create window");
        }

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        glViewport(0, 0, width, height);
        glEnable(GL_DEPTH_TEST);
        glfwSwapInterval(1);

        GLFW.glfwShowWindow(window);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        glfwSetFramebufferSizeCallback(window, (win, w, h) -> {
            glViewport(0, 0, w, h);
        });
    }

    public void run() {
        
        double last_time = glfwGetTime();

        while (!glfwWindowShouldClose(window)) {

            // computing delta time
            double current_time = glfwGetTime();
            delta_time = current_time - last_time;
            last_time = current_time;

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            draw();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        glfwTerminate();
    }

    public void draw() {
        
    }

}
