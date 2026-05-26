package org.echox.scene.lights;

import org.echox.scene.Node3D;

public class DirectionalLight extends Node3D {

    private float intensity;

    public DirectionalLight() {
        intensity = 1.0f;
    }

    public float getIntensity() { return intensity; }
    public void setIntensity(float value) {
        intensity = value;
    }

    

}
