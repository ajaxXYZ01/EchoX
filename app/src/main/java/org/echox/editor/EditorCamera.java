package org.echox.editor;

import org.echox.core.InputManager;
import org.echox.scene.Camera3D;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

public class EditorCamera extends Camera3D {

    Vector3f input_direction;

    public EditorCamera() {
        input_direction = new Vector3f();
    }

    @Override
    public void _input(InputManager input) {

        if (input.isKeyPressed(GLFW.GLFW_KEY_W))
            input_direction.add(localZ.negate());
        if (input.isKeyPressed(GLFW.GLFW_KEY_S))
            input_direction.add(localZ);
        if (input.isKeyPressed(GLFW.GLFW_KEY_A))
            input_direction.add(localX.negate());
        if (input.isKeyPressed(GLFW.GLFW_KEY_D))
            input_direction.add(localX);
        if (input.isKeyPressed(GLFW.GLFW_KEY_SPACE))
            input_direction.add(0, 0, 1);
        if (input.isKeyPressed(GLFW.GLFW_KEY_Q))
            input_direction.add(0, 0, -1);

        input_direction.normalize();
        translate(input_direction);

        UpdateModelMatrix();
        UpdateViewMatrix();

        input_direction.zero();
    }

}
