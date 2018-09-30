package com.yumin.mp3encoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class VerticesData {

    private static final int BYTE_PRE_FLOAT = 4;
    private static final FloatBuffer verticesData;

    private static float[] tableVerticesWithTriangles = {
            //三角形1
            0,0,
            0,14,
            0,14,

            //三角形2
            0,0,
            9,0,
            9,14,

            //中线
            0,7,
            9,7,

            4.5f,2,
            4.5f,12
    };

    static {
        verticesData = ByteBuffer.allocateDirect(tableVerticesWithTriangles.length*BYTE_PRE_FLOAT)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        verticesData.put(tableVerticesWithTriangles);
    }
}
