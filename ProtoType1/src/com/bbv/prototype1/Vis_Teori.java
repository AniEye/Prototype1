package com.bbv.prototype1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

public class Vis_Teori extends Activity {
	protected DrawerLayout _drawerLayout;
	protected ListView _listView;
	protected ActionBarDrawerToggle _actionDrawerToggle;
	protected String[] _testArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vis_teori);
		
		_drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
		
	}
}
