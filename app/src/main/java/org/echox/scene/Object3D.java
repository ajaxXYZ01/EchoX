package org.echox.scene;

import org.echox.graphics.Mesh;
import org.echox.graphics.Renderer;

public class Object3D extends Node3D {

    Mesh mesh;

    public Object3D() {
        
    }

    @Override
    public void _render(Renderer renderer) {
        renderer.getBasicShader().setMatrix4f("model", model);
        mesh.render();
    }
    
}
