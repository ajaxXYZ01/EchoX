package org.echox.scene;

import org.echox.graphics.Mesh;
import org.echox.graphics.Renderer;

public class Object3D extends Node3D {

    protected Mesh mesh;

    public Object3D() {
        
    }

    // Note: mesh lives in caller's memory
    public Object3D(Mesh mesh) {
        this.mesh = mesh;
    }

    public Mesh getMesh() { return mesh; }

    // --------------------------------
    // OVERRIDES
    // --------------------------------

    @Override
    public void _render(Renderer renderer) {
        
        renderer.getBasicShader().setMatrix4f("model", model);

        if (mesh != null)
            mesh.render();

        super._render(renderer);
    }
    
}
