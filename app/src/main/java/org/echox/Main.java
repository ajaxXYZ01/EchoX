package org.echox;
import org.echox.core.Window;
import org.echox.graphics.Renderer;
import org.echox.scene.Camera3D;
import org.echox.scene.Scene;
import org.echox.scene.primitives.Cube;

public class Main {

    public static void main(String args[]) {
        
        Renderer DEFAULT_RENDERER = new Renderer();
        Scene    DEFAULT_SCENE    = new Scene();
        Camera3D DEFAULT_CAMERA   = new Camera3D();

        Window window = new Window(
            "EchoX",
            DEFAULT_RENDERER
        );
        
        Cube cube = new Cube() {
            @Override
            public void _physics_update(double delta_time) {
                rotateZ((float) delta_time);
                UpdateModelMatrix();
            }
        };
        
        DEFAULT_SCENE.addNode(cube);

        DEFAULT_CAMERA.rotate(45, 0, 45);
        DEFAULT_CAMERA.translate(6, -4, 4);

        DEFAULT_CAMERA.UpdateModelMatrix();
        DEFAULT_CAMERA.UpdateProjectionMatrix();
        DEFAULT_CAMERA.UpdateViewMatrix();

        DEFAULT_SCENE.setActiveCamera(DEFAULT_CAMERA);

        window.run(DEFAULT_SCENE);

    }
    
}
