package com.bbv.prototype1;

import android.content.Context;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Til_Viskos extends Basic_Calc {
	LinearLayout _linLay;
	Button _clear;
	int[] _textFieldsStatus = { 0, 0, 0 };
	OnFocusChangeListener focChan;
	OnClickListener cliLis;

	// indexes: 0=theta, 1=RPM, 2=tilvisk
	EditText[] textFields = new EditText[3];

	public Til_Viskos(Context context) {
		super(context, 3);
		CreateListeners();
		Initialize();
	}

	protected void Initialize() {
		_linLay = setAndGetLinearLayout(R.layout.activity_viskositet__tilsynelatende);

		textFields[0] = FindAndReturnEditText(R.id.etTheta, focChan);
		textFields[1] = FindAndReturnEditText(R.id.etRPM, focChan);
		textFields[2] = FindAndReturnEditText(R.id.etViskosTil, focChan);
		_clear = FindAndReturnButton(R.id.bClear, cliLis);
	}

	protected void CreateListeners() {

		cliLis = new OnClickListener() {

			@Override
			public void onClick(View v) {
				ResetFields(textFields);
				_textFieldsStatus = new int[] { 0, 0, 0 };				
			}
		};

		focChan = new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				switch (v.getId()) {
				case R.id.etTheta:
					FocusChange(0, hasFocus);
					break;
				case R.id.etRPM:
					FocusChange(1, hasFocus);
					break;
				case R.id.etViskosTil:
					FocusChange(2, hasFocus);
					break;
				}
			}
		};
	}

	protected void FocusChange(int indexOfCurrentField, boolean focusStatus) {
		String _fieldsString = textFields[indexOfCurrentField].getText()
				.toString();

		if (theSum(_textFieldsStatus) < 2) {
			if (focusStatus == false && !_fieldsString.contentEquals("")) {
				try {
					if (Float.parseFloat(_fieldsString) != 0) {
						_textFieldsStatus[indexOfCurrentField] = 1;
					}
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
		} else {
			if (_textFieldsStatus[indexOfCurrentField] == 1) {
				if (focusStatus == false && _fieldsString.contentEquals("")) {
					try {
						if (Float.parseFloat(_fieldsString) == 0) {
							_textFieldsStatus[indexOfCurrentField] = 0;
							Enabeling(textFields);
						}
					} catch (NumberFormatException e) {
						_textFieldsStatus[indexOfCurrentField] = 0;
						Enabeling(textFields);
					}
				} else if (focusStatus == false
						&& !_fieldsString.contentEquals("")) {
					updateRelevantResult();
				}

			} else {
				updateRelevantResult();
				textFields[indexOfCurrentField].setEnabled(false);
			}
		}
	}

	protected void updateRelevantResult() {
		for (int i = 0; i < _textFieldsStatus.length; i++) {
			if (_textFieldsStatus[i] == 0) {
				textFields[i].setText(calculation(i,
						getFloatVariables(textFields)));
				textFields[i].setEnabled(false);
				break;
			}
		}
	}

	protected String calculation(int editTextIndex, float... fieldStatuses) {
		float theAnswer = 0;
		switch (editTextIndex) {
		case 0:// theta
			theAnswer = (float) ((fieldStatuses[2] * fieldStatuses[1]) / 300);
			break;
		case 1:// rpm
			theAnswer = (float) ((300.0 * fieldStatuses[0]) / fieldStatuses[2]);
			break;
		case 2:// tilvisk
			theAnswer = (float) ((300.0 * fieldStatuses[0]) / fieldStatuses[1]);
			break;
		}
		return theAnswer + "";
	}
}
