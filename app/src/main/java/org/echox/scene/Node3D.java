package org.echox.scene;

import org.echox.graphics.Renderer;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Node3D extends Node {
    
    protected Vector3f position;    // local position, in world units
    protected Vector3f rotation;    // local rotation, in rads
    protected Vector3f scale;       // local scale

    protected Matrix4f model;
    protected Vector3f localX, localY, localZ;

    private Matrix4f rotation_matrix;

    public Node3D() {

        super();

        position = new Vector3f(0.0f, 0.0f, 0.0f);
        rotation = new Vector3f(0.0f, 0.0f, 0.0f);
        scale    = new Vector3f(1.0f, 1.0f, 1.0f);

        localX = new Vector3f(1, 0, 0);
        localY = new Vector3f(0, 1, 0);
        localZ = new Vector3f(0, 0, 1);

        model = new Matrix4f();
        rotation_matrix = new Matrix4f();
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

    public void setPosition(float px, float py, float pz) {
        position.x = px;
        position.y = py;
        position.z = pz;
    }

    public void setPosition(Vector3f position) {
        setPosition(position.x, position.y, position.z);
    }

    // ----------------------------------------------------------------

    // rotating local rotation
    public void rotateX(float x_rads) { rotation.x += x_rads; }
    public void rotateY(float y_rads) { rotation.y += y_rads; }
    public void rotateZ(float z_rads) { rotation.z += z_rads; }

    public void rotate(float x_rads, float y_rads, float z_rads) {
        rotateX(x_rads);
        rotateY(y_rads);
        rotateZ(z_rads);
    }

    // ----------------------------------------------------------------

    // scaling local scale
    public void scaleX(float scale_x) { scale.x *= scale_x; }
    public void scaleY(float scale_y) { scale.y *= scale_y; }
    public void scaleZ(float scale_z) { scale.z *= scale_z; }

    public void scale(float scale_x, float scale_y, float scale_z) {
        scaleX(scale_x);
        scaleY(scale_y);
        scaleZ(scale_z);
    }

    public void scale(float scale) {
        scaleX(scale);
        scaleY(scale);
        scaleZ(scale);
    }

    public void setScaleX(float scale_x) { scale.x = scale_x; }
    public void setScaleY(float scale_y) { scale.y = scale_y; }
    public void setScaleZ(float scale_z) { scale.z = scale_z; }

    public void setScale(float scale_x, float scale_y, float scale_z) {
        setScaleX(scale_x);
        setScaleY(scale_y);
        setScaleZ(scale_z);
    }

    public void setScale(float scale) {
        setScaleX(scale);
        setScaleY(scale);
        setScaleZ(scale);
    }


    // --------------------------------
    // GETTERS
    // --------------------------------

    public Vector3f getPosition() { return position; }
    public Vector3f getRotation() { return rotation; }
    public Vector3f getScale() { return scale; }

    public Vector3f getLocalX() { return localX; }
    public Vector3f getLocalY() { return localY; }
    public Vector3f getLocalZ() { return localZ; }

    // --------------------------------
    // UPDATES
    // --------------------------------

    public void UpdateModelMatrix() {
        model.identity()
            .translate(position)
            .rotateX(rotation.x)
            .rotateY(rotation.y)
            .rotateZ(rotation.z)
            .scale(scale);
        
        UpdateLocalAxis();
    }

    private void UpdateLocalAxis() {

        rotation_matrix
        .identity()
        .rotateXYZ(
            rotation.x,
            rotation.y,
            rotation.z
        );

        localX.set(1, 0, 0);
        localY.set(0, 1, 0);
        localZ.set(0, 0, 1);

        rotation_matrix.transformDirection(localX);
        rotation_matrix.transformDirection(localY);
        rotation_matrix.transformDirection(localZ);

        localX.normalize();
        localY.normalize();
        localZ.normalize();

    }

    // --------------------------------
    // OVERRIDES
    // --------------------------------

    @Override
    public void _physics_update(double delta_time) {
        super._physics_update(delta_time);
    }

    @Override
    public void _render(Renderer renderer) {
        super._render(renderer);
        // maybe we can render its local axis here
    }

}
