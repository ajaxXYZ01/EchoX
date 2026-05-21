package org.echox.graphics;

import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Shader {

    int SHADER_PROGRAM_ID;

    public Shader(String vertex_shader_source_path, String fragment_shader_source_path) throws IOException {

        String vertex_shader_source_code   = Files.readString(Path.of(vertex_shader_source_path));
        String fragment_shader_source_code = Files.readString(Path.of(fragment_shader_source_path));

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

}
