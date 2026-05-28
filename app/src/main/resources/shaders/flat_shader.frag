#version 330 core

in vec3 fragment_normal;

out vec4 color;

uniform vec3 light_direction;
uniform float ambient_strength;
uniform vec3 ambient_color;

void main() {

    float light = dot(normalize(fragment_normal), -light_direction) + ambient_strength;

    light = max(light, 0.0);
    
    color = vec4(light * ambient_color, 1.0);
}
