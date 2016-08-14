package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TopBar topBar = (TopBar) findViewById(R.id.topbar);
       topBar.setOnLeftButtonClickListener(new TopBarListener() {
		
		@Override
		public void leftButtonClick() {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
		}
	}) ;
    }
}
