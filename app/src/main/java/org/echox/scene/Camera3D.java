package org.echox.scene;

import org.joml.Matrix4f;

public class Camera3D extends Node3D {

    float fov;          // in radians
    float zNear, zFar;  // in world units
    float aspect_ratio;

    Matrix4f view, projection;

    public Camera3D(Node parent) {
        super(parent);

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

    public void setFOV(float fov) {
        if (fov < 0 || fov > 90) {
            System.out.println("Camera3D: fov out of range [0, 90]");
            return;
        }

        this.fov = fov;

    }

    public void setZNear(float zNear) { this.zNear = zNear; }
    public void setZFar(float zFar) { this.zFar = zFar; }

    public void UpdateViewMatrix() {

    }

    public void UpdateProjectionMatrix() {
        projection.perspective(
            fov,
            aspect_ratio,
            zNear,
            zFar
        );
    }

}
