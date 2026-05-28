package org.echox.editor;

import org.echox.core.InputManager;
import org.echox.scene.Camera3D;
import org.joml.Vector3f;

public class EditorCamera extends Camera3D {

    Vector3f direction;

    public EditorCamera() {
        direction = new Vector3f();
    }

    @Override
    public void _input(InputManager input) {

        // handle input logic

    }

}
