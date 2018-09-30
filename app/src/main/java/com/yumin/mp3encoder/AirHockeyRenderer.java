package com.yumin.mp3encoder;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;

public class AirHockeyRenderer implements GLSurfaceView.Renderer {

    private String verticesShader;
    private String fragmentShader;
    private int mProgramId;


    public AirHockeyRenderer(Context context) {
        fragmentShader = ShaderLoader.readTextFileFromRawResource(context,R.raw.fragment_shader);
        verticesShader = ShaderLoader.readTextFileFromRawResource(context,R.raw.vertices_shader);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        glClearColor(1f,0,0,0);
        int shaderFragmentId = ShaderHelper.compileFragmentShader(fragmentShader);
        int shaderVertexId = ShaderHelper.compileVertexShader(verticesShader);
        mProgramId = ShaderHelper.linkProgram(shaderVertexId,shaderFragmentId);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        glViewport(0,0,width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
