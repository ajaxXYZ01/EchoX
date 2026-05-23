package org.echox.scene;

import org.echox.graphics.Renderer;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Node3D extends Node {
    
    protected Vector3f position;    // local position, in world units
    protected Vector3f rotation;    // local rotation, in rads
    protected Vector3f scale;       // local scale

    protected Matrix4f model;

    public Node3D() {

        position = new Vector3f(0.0f, 0.0f, 0.0f);
        rotation = new Vector3f(0.0f, 0.0f, 0.0f);
        scale    = new Vector3f(1.0f, 1.0f, 1.0f);

        model = new Matrix4f();

    }

    // --------------------------------
    // TRANSFORMATIONS
    // --------------------------------

    // translating local position
    public void translate(float delta_x, float delta_y, float delta_z) {
        position.x += delta_x;
        position.y += delta_y;
        position.z += delta_z;
    }

    public void translate(Vector3f delta_position) {
        translate(delta_position.x, delta_position.y, delta_position.z);
    }

    // rotating local rotation
    public void rotate_x(float x_rads) { rotation.x += x_rads; }
    public void rotate_y(float y_rads) { rotation.y += y_rads; }
    public void rotate_z(float z_rads) { rotation.z += z_rads; }

    public void rotate(float x_rads, float y_rads, float z_rads) {
        rotate_x(x_rads);
        rotate_y(y_rads);
        rotate_z(z_rads);
    }

    // scaling local scale
    public void scale_x(float scale_x) { scale.x *= scale_x; }
    public void scale_y(float scale_y) { scale.y *= scale_y; }
    public void scale_z(float scale_z) { scale.z *= scale_z; }

    public void scale(float scale_x, float scale_y, float scale_z) {
        scale_x(scale_x);
        scale_y(scale_y);
        scale_z(scale_z);
    }

    public void set_scale_x(float scale_x) { scale.x = scale_x; }
    public void set_scale_y(float scale_y) { scale.y = scale_y; }
    public void set_scale_z(float scale_z) { scale.z = scale_z; }

    public void set_scale(float scale_x, float scale_y, float scale_z) {
        set_scale_x(scale_x);
        set_scale_y(scale_y);
        set_scale_z(scale_z);
    }

    @Override
    public void _physics_update(double delta_time) {
        
    }

    @Override
    public void _render(Renderer renderer) {
        // maybe we can render its local axis here
    }

}
