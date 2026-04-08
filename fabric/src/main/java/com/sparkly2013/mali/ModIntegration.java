package com.sparkly2013.mali;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModIntegration implements ClientModInitializer {

    private static MaliGLES32Backend backend;
    private static MaliG52Profiler profiler;
    private static ChunkMeshGenerator meshGenerator;

    @Override
    public void onInitializeClient() {
        System.out.println("[Sodium Mali G52] Initializing rendering engine...");
        
        try {
            backend = new MaliGLES32Backend();
            profiler = new MaliG52Profiler();
            meshGenerator = new ChunkMeshGenerator(backend);
            
            backend.initializeUBO();
            backend.configureTextureUnits(16);
            backend.enableTileBasedDeferredRendering();
            
            System.out.println("[Sodium Mali G52] ✅ Rendering engine initialized successfully!");
            System.out.println("[Sodium Mali G52] Mali G52 TBDR optimization enabled");
            System.out.println("[Sodium Mali G52] Target: Samsung Galaxy A14 (4GB RAM)");
        } catch (Exception e) {
            System.err.println("[Sodium Mali G52] ❌ Failed to initialize: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static MaliGLES32Backend getBackend() {
        return backend;
    }

    public static MaliG52Profiler getProfiler() {
        return profiler;
    }

    public static ChunkMeshGenerator getMeshGenerator() {
        return meshGenerator;
    }
}
