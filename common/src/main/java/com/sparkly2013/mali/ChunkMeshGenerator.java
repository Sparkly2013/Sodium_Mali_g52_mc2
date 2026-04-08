package com.sparkly2013.mali;

public class ChunkMeshGenerator {
    private MaliGLES32Backend backend;

    public ChunkMeshGenerator(MaliGLES32Backend backend) {
        this.backend = backend;
    }

    public void generateChunkMesh(byte[] blockData) {
        for (int i = 0; i < blockData.length; i++) {
            if (blockData[i] != 0) {
                int x = i % 16;
                int y = (i / 16) % 16;
                int z = i / 256;
            }
        }
    }
}
