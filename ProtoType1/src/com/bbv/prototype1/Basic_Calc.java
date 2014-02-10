package com.bbv.prototype1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public abstract class Basic_Calc extends LinearLayout {

	Context cont;
	ArrayList<Integer> _editedFields;

	LinearLayout _linLay;

	public Basic_Calc(Context context, int numberOfFields) {
		super(context);
		cont = context;
	}

	protected abstract void Initialize();

	// the user should use this method for all the listeners that are used in
	// the class
	// extending Basic_Calc
	protected abstract void CreateListeners();

	protected LinearLayout setAndGetLinearLayout(int layoutID) {
		_linLay = (LinearLayout) LayoutInflater.from(cont).inflate(layoutID,
				this);
		return _linLay;
	}

	protected EditText FindAndReturnEditText(int id,
			OnFocusChangeListener aListener) {

		EditText aField = (EditText) _linLay.findViewById(id);
		aField.setOnFocusChangeListener(aListener);

		return aField;
	}

	protected Button FindAndReturnButton(int id, OnClickListener aListener) {
		Button aButton = (Button) _linLay.findViewById(id);
		aButton.setOnClickListener(aListener);
		return aButton;
	}

	//
	// protected abstract void FocusChange(EditText theCurrentField, int index,
	// boolean focusStatus);

	protected void Enabeling(EditText... _theEditTextFields) {
		for (int i = 0; i < _theEditTextFields.length; i++) {
			if (!_theEditTextFields[i].isEnabled()) {
				_theEditTextFields[i].setEnabled(true);
				_theEditTextFields[i].setText("");
			}
		}
	}
	
	protected void updateRelevantResult(int[] fieldStatuses, EditText... editTexts ){
		
	}
	protected float[] getFloatVariables(EditText... fieldStatuses ){
		float[] returnFloatList = new float[fieldStatuses.length];
		for(int i=0;i<fieldStatuses.length;i++){
			returnFloatList[i] = Float.parseFloat(fieldStatuses[i].getText().toString());
		}
		return returnFloatList;
	}
	
	protected abstract String calculation(int editTextIndex,float... fieldStatuses );
	
	// protected abstract void updateRelevantResult(String _thetaString,
	// String _RPMString, String _tilSynViskosString);
	//
	protected int theSum(int... fieldStatuses) {
		int sumOfEditedFields = 0;
		for (int i = 0; i < fieldStatuses.length; i++) {
			sumOfEditedFields += fieldStatuses[i];
		}
		return sumOfEditedFields;
	}

}
