package org.echox.scene;

import java.util.ArrayList;

import org.echox.core.InputManager;
import org.echox.graphics.Renderer;

public class Node {

    protected Node parent;
    protected ArrayList <Node> children;

    public Node() {
        children = new ArrayList <> ();
    }

    public Node getParent() { return parent; }
    public Node getChild(int index) { return children.get(index); }
    public ArrayList <Node> getChildren() { return children; }
    
    public void addChild(Node child) {
        child.parent = this;
        children.add(child);
    }

    public void removeChild(Node child) {
        child.parent = null;
        children.remove(child);
    }

    // --------------------------------
    // 
    // --------------------------------

    public void _input(InputManager input) {
        for (Node node : children) {
            node._input(input);
        }
    }

    public void _physics_update(double delta_time) {
        for (Node node : children) {
            node._physics_update(delta_time);
        }
    }

    public void _render(Renderer renderer) {
        for (Node node : children) {
            node._render(renderer); // recursive render calls !
        }
    }

}
