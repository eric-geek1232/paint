package com.example.paint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.drawView = new DrawView(this);
        setContentView(this.drawView);

        //this.addContentView(this.drawView.row, this.drawView.params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_paint_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_all:
                this.drawView.setClean();
                break;

            case R.id.colors:

                break;

            case R.id.brush:
                this.drawView.setPencil();
                break;

            case R.id.eraser:
                this.drawView.setEraser();
                break;
        }
        return true;
    }

    public class DrawView extends View {
        private final int finalWidthCircle = 14;
        private Paint circlePaint; // estilos
        private Path circlePath; // figuras
        private final int finalColor = Color.parseColor("#9Fa9df");

        private Canvas canvas; //*
        private Bitmap bitmap; // almacenar o conservar figuras en un arreglo de bits.
        private Paint bitMapPaint;//*

        private Paint brushPaint;
        private Path brushPath;

        private float lastPosX, lastPosY;

        private Button eraser;
        private Button pencil;
        private Button clean;

        private LayoutParams params;
        private LinearLayout row;
        public DrawView(Context context){
            super(context);
            this.createCircle();
            this.bitMapPaint = new Paint();
            this.createBrush();

            //this.createButtons(context);
            // sentence creates tree buttons when are call them in the constructor they active onClickEvents


            this.setBackgroundColor(Color.WHITE);
        }

        private void createButtons(Context context){
            this.params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            this.row = new LinearLayout(context);
            this.row.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

            this.createEraser(context);
            this.createPencil(context);
            this.createClear(context);

            this.row.addView(this.eraser);
            this.row.addView(this.pencil);
            this.row.addView(this.clean);
        }

        private void createEraser(Context context){
            this.eraser = new Button(context);
            this.eraser.setText("borrador");
            this.eraser.setWidth(200);

            this.eraser.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    setEraser();
                }
            });
        }

        private void createPencil(Context context){
            this.pencil = new Button(context);
            this.pencil.setText("Lapiz");
            this.pencil.setWidth(200);

            this.pencil.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    setPencil();
                }
            });
        }

        private void createClear(Context context){
            this.clean = new Button(context);
            this.clean.setText("clean");
            this.clean.setWidth(200);

            this.clean.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    setClean();
                }
            });
        }

        private void setClean(){
            this.brushPath.reset();
            this.circlePath.reset();
            this.canvas.drawColor(Color.WHITE);
            this.invalidate(); // actualizar el onDraw
            this.setPencil();
        }

        private void setPencil(){
            this.brushPaint.setStrokeWidth(this.finalWidthCircle);
            this.brushPaint.setColor(this.finalColor);
        }

        private void setEraser(){
            this.brushPaint.setStrokeWidth(this.finalWidthCircle +20);
            this.brushPaint.setColor(Color.WHITE);
        }

        private void createCircle(){
            this.circlePaint = new Paint();
            this.circlePath = new Path();

            this.circlePaint.setDither(true);
            this.circlePaint.setAntiAlias(true);
            this.circlePaint.setColor(this.finalColor);
            this.circlePaint.setStyle(Paint.Style.STROKE);
            this.circlePaint.setStrokeWidth(this.finalWidthCircle);
        }

        private void createBrush(){
            this.brushPaint = new Paint();
            this.brushPath = new Path();

            this.brushPaint.setDither(true);
            this.brushPaint.setAntiAlias(true);
            this.brushPaint.setColor(this.finalColor);
            this.brushPaint.setStyle(Paint.Style.STROKE);
            this.brushPaint.setStrokeWidth(this.finalWidthCircle);
            this.brushPaint.setStrokeCap(Paint.Cap.ROUND);// estilo para el lapiz a redondeado
        }

        private void actionMove(float posX, float posY){
            this.circlePath.reset();
            //this.circlePath.addCircle(posX, posY, 30, Path.Direction.CCW);
            this.brushPath.quadTo(this.lastPosX, this.lastPosY, (posX+this.lastPosX)/2, (posY+this.lastPosY)/2); // dibujar curvas
            this.lastPosY = posY;
            this.lastPosX = posX;

            this.circlePath.addCircle(posX, posY, 30, Path.Direction.CCW);
        }

        private void actionUp(){
            this.circlePath.reset();
            this.canvas.drawPath(this.brushPath, this.brushPaint); // antes de eliminar pasamos al cambas asociado a bitmap
            this.brushPath.reset();
        }

        private void actionDown(float posX, float posY){
            this.lastPosX = posX;
            this.lastPosY = posY;

            this.circlePath.reset();
            this.brushPath.reset();
            //this.circlePath.addCircle(posX, posY, 30, Path.Direction.CCW);
            this.brushPath.moveTo(lastPosX, lastPosY); // para que no empiece en 0x, 0y
        }

        private void drawCircule(Canvas canvas) {
            Paint paint = new Paint(); //estilo

            paint.setDither(true);//
            paint.setAntiAlias(true); // acabado
            paint.setStyle(Paint.Style.FILL); // detallado
            paint.setColor(Color.parseColor("#9Fa9df"));//color
            canvas.drawCircle(300, 200, 100, paint);//figura
        }

        private void showMessage(String message){
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            //this.drawCircule(canvas); este metodo se llama para dibujar una figura
            canvas.drawBitmap(this.bitmap, 0,0,this.bitMapPaint); // recycla las figuras.
            canvas.drawPath(this.brushPath, this.brushPaint);
            canvas.drawPath(this.circlePath, this.circlePaint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            //this.showMessage("Touch Event");
            float posX = event.getX();
            float posY = event.getY();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    this.actionDown(posX, posY);
                    break;

                case MotionEvent.ACTION_MOVE:
                    this.actionMove(posX, posY);
                    break;

                case MotionEvent.ACTION_UP:
                    this.actionUp();
                    break;
            }

            this.invalidate();
            return true;
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            this.bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            this.canvas = new Canvas(this.bitmap); //asociacion de mapas de bip con canvas para despues dibujarlo
        }
    }
}
