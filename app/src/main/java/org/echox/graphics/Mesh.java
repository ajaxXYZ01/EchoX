package org.echox.graphics;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;

public class Mesh {
    
    /*
    flat array of floating point numbers
    representing 3D coordinates of each vertex [x1, y1, z1, x2, y2, z2, x3, y3, z3, ... ]
     */
    protected float vertices [];
    protected int indices[];
    int VAO, VBO, EBO; // Vertex Array Object ID, Vertex Buffer Object ID

    public Mesh(float vertices[], int indices[]) {
        this.vertices = vertices;
        this.indices  = indices;

        uploadToGPU();
    }

    void uploadToGPU() {

        VAO = glGenVertexArrays();
        VBO = glGenBuffers();
        EBO = glGenBuffers();

        glBindVertexArray(VAO);

        // VBO
        glBindBuffer(GL_ARRAY_BUFFER, VBO);

        /*
        FLoatBuffer, IntBuffer is LWJGL class and handles pointers by itself
        e.g. while calling glBufferData()
        */
        FloatBuffer vertexBuffer = MemoryUtil.memAllocFloat(vertices.length); // allocating a native memory
        vertexBuffer.put(vertices).flip(); // uploading data from heap to native memory

        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW); // reads from native memory automatically

        // EBO
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
        IntBuffer indexBuffer = MemoryUtil.memAllocInt(indices.length);
        indexBuffer.put(indices).flip();
            
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL_STATIC_DRAW);

        glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * Float.BYTES, 0);
        glEnableVertexAttribArray(0);

        glBindVertexArray(0);

        MemoryUtil.memFree(vertexBuffer);
        MemoryUtil.memFree(indexBuffer);
    }

    public void render() {
        glBindVertexArray(VAO);
        glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_INT, 0);
        glBindVertexArray(0);
    }

}
