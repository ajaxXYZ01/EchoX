package org.echox.scene;

import java.util.ArrayList;

public class Node {

    protected Node parent;
    protected ArrayList <Node> children;

    public Node(Node parent) {
        this.parent = parent;
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

}
