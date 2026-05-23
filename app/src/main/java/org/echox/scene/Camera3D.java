package org.echox.scene;

import org.joml.Matrix4f;

public class Camera3D extends Node3D {

    private float fov;          // in radians
    private float zNear, zFar;  // in world units
    private float aspect_ratio;

    private Matrix4f view, projection;

    public Camera3D() {

        fov = (float) Math.toRadians(45d);
        zNear = 0.1f;
        zFar  = 1000f;
        aspect_ratio = 800 / 600f;

        view = new Matrix4f();
        projection = new Matrix4f();

        view.identity();
        projection.perspective(
            fov,
            aspect_ratio,
            zNear,
            zFar
        );

    }

    // --------------------------------
    // GETTERS
    // --------------------------------

    public Matrix4f getViewMatrix() { return view; }
    public Matrix4f getProjectionMatrix() { return projection; }

    public float getFOV_Degrees() {
        return (float) Math.toDegrees(fov);
    }

    public float getFOV_Radians() {
        return fov;
    }

    // --------------------------------
    // SETTERS
    // --------------------------------

    public void setFOV(float fov) {
        if (fov < 0 || fov > Math.toRadians(90)) {
            System.out.println("Camera3D: fov out of range [0, 90]");
            return;
        }

        this.fov = fov;

    }

    public void setZNear(float zNear) { this.zNear = zNear; }
    public void setZFar(float zFar) { this.zFar = zFar; }

    // --------------------------------
    // UPDATE METHODS
    // --------------------------------

    public void UpdateViewMatrix() {
        view.identity()
            .rotateX(-rotation.x)
            .rotateY(-rotation.y)
            .rotateZ(-rotation.z)
            .translate(-position.x, -position.y, -position.z);
    }

    public void UpdateProjectionMatrix() {
        projection.identity().perspective(
            fov,
            aspect_ratio,
            zNear,
            zFar
        );
    }

}
