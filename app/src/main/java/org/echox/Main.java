package org.echox;

import org.echox.core.Window;
import org.echox.graphics.Renderer;
import org.echox.scene.Scene;
import org.echox.scene.primitives.Cube;

public class Main {

    public static void main(String args[]) {
        
        Renderer DEFAULT_RENDERER  = new Renderer();
        Scene    DEFAULT_SCENE     = new Scene();

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

        window.run(DEFAULT_SCENE);

    }
    
}
