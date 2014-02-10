package com.bbv.prototype1;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

public abstract class Basic_Calc extends LinearLayout{

	Context cont;
	
	public Basic_Calc (Context context) {
		super(context);
		cont= context;
		// TODO Auto-generated constructor stub
		CreateListeners();
		Initialize();
	}

	protected abstract void Initialize();

	protected abstract void CreateListeners();
	
	protected abstract void FocusChange(EditText theCurrentField, int index,
			boolean focusStatus);
	
	protected abstract void Enabeling();
	
	protected abstract String calculation(int type, float number1, float number2);
	
	protected abstract void updateRelevantResult(String _thetaString, String _RPMString,
			String _tilSynViskosString);
	
	protected abstract int theSum();
	
}
