package org.echox.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.echox.graphics.Shader;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window {

    private long window;
    double delta_time;

    Shader BasicShader;

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
        glfwSwapInterval(1); // Anti-aliasing ON

        GLFW.glfwShowWindow(window);
        glClearColor(0.025f, 0.025f, 0.025f, 1.0f);

        // Centering the window
        long primary_window = GLFW.glfwGetPrimaryMonitor();
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(primary_window);

        int xPos = (vidMode.width() - width) / 2;
        int yPos = (vidMode.height() - height) / 2;

        GLFW.glfwSetWindowPos(window, xPos, yPos);

        // Resizing the viewport on window resize
        glfwSetFramebufferSizeCallback(window, (win, w, h) -> {
            glViewport(0, 0, w, h);
        });

        try {
            BasicShader = new Shader(
                "app\\src\\main\\resources\\shaders\\basic.vert",
                "app\\src\\main\\resources\\shaders\\basic.frag");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        
        double last_time = glfwGetTime();

        BasicShader.use();

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
