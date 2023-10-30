package com.example.menupractic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        int itemId = item.getItemId();

        if (itemId == R.id.call) {
            msg = "Cart clicked";
        } else if (itemId == R.id.call) {
            msg = "Call clicked";
        } else if (itemId == R.id.camera) {
            item.setChecked(true);
            msg = "Camera clicked";
        } else if (itemId == R.id.video) {
            item.setChecked(true);
            msg = "Video clicked";
        } else if (itemId == R.id.email) {
            msg = "Email clicked";
        } else if (itemId == R.id.add) {
            msg = "Add clicked";
        } else if (itemId == R.id.copy) {
            msg = "Copy clicked";
        } else if (itemId == R.id.paste) {
            msg = "Paste clicked";
        } else if (itemId == R.id.help) {
            msg = "Help clicked";
        } else {
            return super.onOptionsItemSelected(item);
        }

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        System.out.println("onCreateOptionsMenu ...");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        if(menu.getClass().getSimpleName().equals("MenuBuilder")){
            try{
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}