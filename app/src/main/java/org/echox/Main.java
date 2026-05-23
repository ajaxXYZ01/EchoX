package org.echox;
import org.echox.core.Window;
import org.echox.graphics.Renderer;
import org.echox.scene.Camera3D;
import org.echox.scene.Scene;

public class Main {

    public static void main(String args[]) {

        Renderer DEFAULT_RENDERER   = new Renderer();
        Scene DEFAULT_SCENE = new Scene();
        Camera3D DEFAULT_CAMERA = new Camera3D();
        
        Window window = new Window(
            "EchoX",
            DEFAULT_RENDERER
        );

        window.run(DEFAULT_SCENE, DEFAULT_CAMERA);
    }
    
}
