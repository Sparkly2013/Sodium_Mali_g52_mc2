package com.sparkly2013.mali;

public class MaliGLES32Backend {
    public void initializeUBO() { }
    public void updateUBO(int uboIndex, float[] data) { }
    public void createVAO(int vaoID) { }
    public void bindVAO(int vaoID) { }
    public void deleteVAO(int vaoID) { }
    public void configureTextureUnits(int numUnits) { }
    public void bindTexture(int unit, int textureID) { }
    public int compileShader(String vertexSource, String fragmentSource) { return 0; }
    public void useShaderProgram(int programID) { }
    public void setUniform(String uniformName, float[] data) { }
    public void enableBlending() { }
    public void disableBlending() { }
    public void setBlendMode(int srcBlend, int dstBlend) { }
    public void enableDepthTest() { }
    public void disableDepthTest() { }
    public void setDepthFunc(int depthFunc) { }
    public void enableTileBasedDeferredRendering() { }
    public void setSampleMask(int mask) { }
}
