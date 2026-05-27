package org.echox.graphics;

import java.io.IOException;

import org.echox.scene.Scene;

public class Renderer {

    private int resolution_x, resolution_y;

    Shader BASIC_SHADER;

    // enum RenderMode {
    //     WIREFRAME,
    //     FLAT,
    //     SMOOTH
    // }

    public Renderer() {
        resolution_x = 800;
        resolution_y = 600;
    }

    public void init() {
        try {
            BASIC_SHADER = new Shader(
                "shaders/flat_shader.vert",
                "shaders/flat_shader.frag");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void render(Scene scene) {

        BASIC_SHADER.use();
        // take this to Shader class so each know how to render itself. pass nessecerry parameters
        BASIC_SHADER.setMatrix4f("view", scene.getActiveCamera().getViewMatrix());
        BASIC_SHADER.setMatrix4f("projection", scene.getActiveCamera().getProjectionMatrix());
        BASIC_SHADER.setVector3f("light_direction", scene.getActiveCamera().getForward());
        BASIC_SHADER.setFloat("ambient_strength", scene.getAmbientStrength());

        scene.getRoot()._render(this);
    }

    public int getResolutionX() { return resolution_x; }
    public int getResolutionY() { return resolution_y; }

    public Shader getBasicShader() { return BASIC_SHADER; }

}
