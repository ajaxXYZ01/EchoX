package org.echox.scene;

public class Scene {
    
    private Node ROOT_NODE;
    private Camera3D activeCamera;

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
        activeCamera = camera;
    }

    public void _physics_update_scene_tree(double delta_time) {
        ROOT_NODE._physics_update(delta_time);
    }

}
