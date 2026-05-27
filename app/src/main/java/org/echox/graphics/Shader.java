package org.echox.graphics;

import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

public class Shader {

    int SHADER_PROGRAM_ID;

    public Shader(String vertex_shader_source_path, String fragment_shader_source_path) throws IOException {

        String vertex_shader_source_code   = new String(
            getClass().getClassLoader()
                .getResourceAsStream(vertex_shader_source_path)
                .readAllBytes()
        );

        String fragment_shader_source_code = new String(
            getClass().getClassLoader()
                .getResourceAsStream(fragment_shader_source_path)
                .readAllBytes()
        );

        int VERTEX_SHADER_ID = glCreateShader(GL_VERTEX_SHADER);
        int FRAGMENT_SHADER_ID = glCreateShader(GL_FRAGMENT_SHADER);

        glShaderSource(VERTEX_SHADER_ID, vertex_shader_source_code);
        glShaderSource(FRAGMENT_SHADER_ID, fragment_shader_source_code);

        glCompileShader(VERTEX_SHADER_ID);
        glCompileShader(FRAGMENT_SHADER_ID);

        SHADER_PROGRAM_ID = glCreateProgram();

        glAttachShader(SHADER_PROGRAM_ID, VERTEX_SHADER_ID);
        glAttachShader(SHADER_PROGRAM_ID, FRAGMENT_SHADER_ID);

        glLinkProgram(SHADER_PROGRAM_ID);

        System.out.println(glGetShaderInfoLog(VERTEX_SHADER_ID));
        System.out.println(glGetShaderInfoLog(FRAGMENT_SHADER_ID));
        System.out.println(glGetProgramInfoLog(SHADER_PROGRAM_ID));

        glDeleteShader(VERTEX_SHADER_ID);
        glDeleteShader(FRAGMENT_SHADER_ID);
    }

    public int getID() { return SHADER_PROGRAM_ID; }

    public void use() {
        glUseProgram(SHADER_PROGRAM_ID);
    }

    public void setMatrix4f(String uniform_name, Matrix4f matrix) {
        int location = glGetUniformLocation(SHADER_PROGRAM_ID, uniform_name);
        FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
        matrix.get(buffer);
        glUniformMatrix4fv(location, false, buffer);
    }

    public void setVector3f(String uniform_name, Vector3f vector) {
        int location = glGetUniformLocation(SHADER_PROGRAM_ID, uniform_name);
        glUniform3f(location, vector.x, vector.y, vector.z);
    }

    public void setFloat(String uniform_name, float value) {
        glUniform1f(glGetUniformLocation(SHADER_PROGRAM_ID, uniform_name), value);
    }
}
