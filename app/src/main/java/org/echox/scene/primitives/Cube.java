package org.echox.scene.primitives;

import org.echox.graphics.Mesh;
import org.echox.scene.Object3D;

public class Cube extends Object3D {

    public Cube() {
        super();

        float vertices [] = {

            // FRONT (+Z)
            -0.5f, -0.5f,  0.5f,    0f, 0f,  1f,
             0.5f, -0.5f,  0.5f,    0f, 0f,  1f,
             0.5f,  0.5f,  0.5f,    0f, 0f,  1f,
            -0.5f,  0.5f,  0.5f,    0f, 0f,  1f,

            // BACK (-Z)
            -0.5f, -0.5f, -0.5f,    0f, 0f, -1f,
             0.5f, -0.5f, -0.5f,    0f, 0f, -1f,
             0.5f,  0.5f, -0.5f,    0f, 0f, -1f,
            -0.5f,  0.5f, -0.5f,    0f, 0f, -1f,

            // LEFT (-X)
            -0.5f, -0.5f, -0.5f,   -1f, 0f,  0f,
            -0.5f, -0.5f,  0.5f,   -1f, 0f,  0f,
            -0.5f,  0.5f,  0.5f,   -1f, 0f,  0f,
            -0.5f,  0.5f, -0.5f,   -1f, 0f,  0f,

            // RIGHT (+X)
             0.5f, -0.5f, -0.5f,    1f, 0f,  0f,
             0.5f, -0.5f,  0.5f,    1f, 0f,  0f,
             0.5f,  0.5f,  0.5f,    1f, 0f,  0f,
             0.5f,  0.5f, -0.5f,    1f, 0f,  0f,

            // TOP (+Y)
            -0.5f,  0.5f, -0.5f,    0f, 1f,  0f,
            -0.5f,  0.5f,  0.5f,    0f, 1f,  0f,
             0.5f,  0.5f,  0.5f,    0f, 1f,  0f,
             0.5f,  0.5f, -0.5f,    0f, 1f,  0f,

            // BOTTOM (-Y)
            -0.5f, -0.5f, -0.5f,    0f,-1f,  0f,
            -0.5f, -0.5f,  0.5f,    0f,-1f,  0f,
             0.5f, -0.5f,  0.5f,    0f,-1f,  0f,
             0.5f, -0.5f, -0.5f,    0f,-1f,  0f,
        };

        int indices [] = {
             0,  1,  2,
             2,  3,  0,

             4,  5,  6,
             6,  7,  4,

             8,  9, 10,
            10, 11,  8,

            12, 13, 14,
            14, 15, 12,

            16, 17, 18,
            18, 19, 16,

            20, 21, 22,
            22, 23, 20
        };

        mesh = new Mesh(vertices, indices);

    }
}
