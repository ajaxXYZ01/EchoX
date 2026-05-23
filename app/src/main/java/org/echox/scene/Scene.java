package org.echox.scene;

public class Scene {
    
    private Node ROOT_NODE;
    private Camera3D active_camera;

    public Scene() {
        ROOT_NODE = new Node();
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

    public void _physics_update_scene_tree(double delta_time) {
        ROOT_NODE._physics_update(delta_time);
    }

}
