package com.kot32.warmenglish.wight;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import com.kot32.warmenglish.R;

public class MyLoadingDialog extends AlertDialog {

	protected MyLoadingDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
		
	}

	protected MyLoadingDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	public MyLoadingDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_loading);
	}
}
