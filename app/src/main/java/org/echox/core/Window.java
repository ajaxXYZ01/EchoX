package org.echox.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.echox.graphics.Renderer;
import org.echox.scene.Scene;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window {

    private long window;
    private InputManager input;
    
    double delta_time;

    Renderer current_renderer;

    public Window(String title, Renderer renderer) {
        
        this.current_renderer = renderer;

        int width  = renderer.getResolutionX();
        int height = renderer.getResolutionY();

        if (!glfwInit()) {
            throw new IllegalStateException("GLFW failed to initialize");
        }

        window = glfwCreateWindow(width, height, title, 0, 0);

        if (window == 0) {
            throw new RuntimeException("Failed to create window");
        }

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        current_renderer.init();
        input = new InputManager(window);

        glViewport(0, 0, width, height);
        glEnable(GL_DEPTH_TEST);
        glfwSwapInterval(1); // Enable VSync


        glfwFocusWindow(window);
        glfwShowWindow(window);
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

    }

    public void run(Scene scene) {
        
        double last_time = glfwGetTime();

        while (!glfwWindowShouldClose(window)) {

            // computing delta time
            double current_time = glfwGetTime();
            delta_time = current_time - last_time;
            last_time = current_time;

            glfwPollEvents();

            input.update();

            input(scene, this.input);

            update_physics(scene, delta_time);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            draw(scene);
        }

        glfwTerminate();
        glfwDestroyWindow(window);
    }

    public void input(Scene scene, InputManager input) {
        scene._update_input_scene_tree(input);
    }
    
    public void update_physics(Scene scene, double delta_time) {
        scene._update_physics_scene_tree(delta_time);
    }
    
    public void draw(Scene scene) {
        current_renderer.render(scene);
        glfwSwapBuffers(window);
    }

    public InputManager getInputManager() { return input; }
    
}
