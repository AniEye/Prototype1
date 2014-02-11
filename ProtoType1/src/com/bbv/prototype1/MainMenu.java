package com.bbv.prototype1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener {

	String[] menuList = { "Pros_og_Teori", "Kalkulator", "Ovinger" };
	Button teori, kalk, ovinger;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);

		teori = (Button) findViewById(R.id.bTeori);
		kalk = (Button) findViewById(R.id.bKalk);
		ovinger = (Button) findViewById(R.id.bOvinger);

		teori.setOnClickListener(this);
		kalk.setOnClickListener(this);
		ovinger.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String selected = "";
		switch (v.getId()) {
		case R.id.bTeori:
			selected = menuList[0];
			break;
		case R.id.bKalk:
			selected = menuList[1];
			break;
		case R.id.bOvinger:
			selected = menuList[2];
			break;
		}
		try {
			Class<?> selectedClass = Class.forName("com.bbv.prototype1."
					+ selected);
			Intent createIntent = new Intent(MainMenu.this, selectedClass);
			startActivity(createIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
