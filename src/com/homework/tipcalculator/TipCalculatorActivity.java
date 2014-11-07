package com.homework.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	private EditText etAmount;
	private Button btnTen;
	private Button btnFifteen;
	private Button btnTwenty;
	private TextView tvTip;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        // get inputs
        etAmount = (EditText) findViewById(R.id.etAmount);
        btnTen = (Button) findViewById(R.id.btnTen);
        btnFifteen = (Button) findViewById(R.id.btnFifteen);
        btnTwenty = (Button) findViewById(R.id.btnTwenty);
        tvTip = (TextView) findViewById(R.id.tvTip);
       
		btnTen.setOnClickListener(amountListener);
        btnFifteen.setOnClickListener(amountListener);
        btnTwenty.setOnClickListener(amountListener);
    }
    // create a common listener for the three buttons
    private Button.OnClickListener amountListener = new Button.OnClickListener() {
    	@Override
    	public void onClick(View v) {
    		double amount=Double.parseDouble(etAmount.getText().toString());
    		switch (v.getId()) {
    		case R.id.btnTen:{
    			double tip=0.1*(double)amount;
    			tvTip.setText("$"+tip);
    			break;
    		}
    		case R.id.btnFifteen:{
    			double tip=0.15*(double)amount;
    			tvTip.setText("$"+tip);
    			break;
    		}
    		case R.id.btnTwenty:{
    			double tip=0.2*(double)amount;
    			tvTip.setText("$"+tip);
    			break;
    		}
    	}
    }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
