package org.echox.graphics;

import java.io.IOException;

import org.echox.scene.Camera3D;
import org.echox.scene.Scene;

public class Renderer {

    private int resolution_x, resolution_y;
    Shader BASIC_SHADER;

    public Renderer() {

        resolution_x = 800;
        resolution_y = 600;

        try {
            BASIC_SHADER = new Shader(
                "app\\src\\main\\resources\\shaders\\basic.vert",
                "app\\src\\main\\resources\\shaders\\basic.frag");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void render(Scene scene, Camera3D camera) {

        BASIC_SHADER.use();
        BASIC_SHADER.setMatrix4f("view", camera.getViewMatrix());
        BASIC_SHADER.setMatrix4f("projection", camera.getProjectionMatrix());
        scene.getRoot()._render(this);

    }

    public int getResolutionX() { return resolution_x; }
    public int getResolutionY() { return resolution_y; }

    public Shader getBasicShader() { return BASIC_SHADER; }

}
