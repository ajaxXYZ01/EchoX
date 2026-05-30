package org.echox.scene;

import org.echox.core.InputManager;
import org.joml.Vector3f;

public class Scene {
    
    private Node ROOT_NODE;
    private Camera3D active_camera;

    float ambient_strength;
    Vector3f ambient_color;

    public Scene() {
        ROOT_NODE = new Node();
        ambient_strength = 0.1f;
        ambient_color = new Vector3f(0.5f, 0.5f, 0.5f);
    }

    public Node getRoot() { return ROOT_NODE; }

    public void addNode(Node node) {
        
        if (ROOT_NODE == null) {
            System.out.println("Scene: root is null");
            return;
        }

        ROOT_NODE.addChild(node);
    }

    public void setActiveCamera(Camera3D camera) {
        active_camera = camera;
    }

    public Camera3D getActiveCamera() { return active_camera; }
    public float getAmbientStrength() { return ambient_strength; }
    public Vector3f getAmbientColor() { return ambient_color; }

    public void _update_input_scene_tree(InputManager input) {
        ROOT_NODE._input(input);
        active_camera._input(input);
    }

    public void _update_physics_scene_tree(double delta_time) {
        ROOT_NODE._physics_update(delta_time);
    }

}
