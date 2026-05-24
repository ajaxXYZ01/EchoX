package org.echox.scene.primitives;

import org.echox.graphics.Mesh;
import org.echox.scene.Object3D;

public class Cube extends Object3D {

    public Cube() {
        super();

        float vertices [] = {
             0.5f,  0.5f,  0.5f, // 0
             0.5f,  0.5f, -0.5f, // 1

             0.5f, -0.5f,  0.5f, // 2
             0.5f, -0.5f, -0.5f, // 3

            -0.5f,  0.5f,  0.5f, // 4
            -0.5f,  0.5f, -0.5f, // 5
            
            -0.5f, -0.5f,  0.5f, // 6
            -0.5f, -0.5f, -0.5f, // 7
        };

        int indices [] = {
            0, 2, 4,
            4, 2, 6,

            3, 1, 7,
            7, 1, 5,

            2, 3, 6,
            6, 3, 7,

            4, 5, 0,
            0, 5, 1,

            6, 7, 4,
            4, 7, 5,

            0, 1, 2,
            2, 1, 3,
        };

        mesh = new Mesh(vertices, indices);

    }
}
