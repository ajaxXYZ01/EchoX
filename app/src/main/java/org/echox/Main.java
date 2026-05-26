package org.echox;
import org.echox.core.Window;
import org.echox.graphics.Renderer;
import org.echox.scene.Camera3D;
import org.echox.scene.Scene;
import org.echox.scene.primitives.Cube;

public class Main {

    public static void main(String args[]) {
        
        Renderer DEFAULT_RENDERER   = new Renderer();
        Scene DEFAULT_SCENE = new Scene();
        Camera3D DEFAULT_CAMERA = new Camera3D();

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

        Cube cube2 = new Cube();

        cube2.translate(1, 1, 1);
        cube2.UpdateModelMatrix();

        DEFAULT_SCENE.addNode(cube);
        DEFAULT_SCENE.addNode(cube2);

        DEFAULT_CAMERA.rotate(45, 0, 45);
        DEFAULT_CAMERA.translate(3, -2, 2);

        DEFAULT_CAMERA.UpdateModelMatrix();
        DEFAULT_CAMERA.UpdateProjectionMatrix();
        DEFAULT_CAMERA.UpdateViewMatrix();

        DEFAULT_SCENE.setActiveCamera(DEFAULT_CAMERA);

        window.run(DEFAULT_SCENE);

    }
    
}
