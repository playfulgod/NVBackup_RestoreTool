package com.oudhitsquad.nvbackuprestoretool;

import java.io.IOException;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NVBackup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nvbackup);

	    final Button button_backup = (Button) findViewById(R.id.button_backup);
	    button_backup.setOnClickListener(new View.OnClickListener() {
		
	    	@Override
			public void onClick(View v) {
	   			Runtime runtime = Runtime.getRuntime();
	            Process proc = null;
	            OutputStreamWriter osw = null;

	            String command="/system/bin/reboot nvbackup";

	            try { // Run Script

	                proc = runtime.exec("su");
	                osw = new OutputStreamWriter(proc.getOutputStream());
	                                    osw.write(command);
	                        osw.flush();
	                osw.close();
	                
	        		Context context = getApplicationContext();
	        		CharSequence text = "Backing NV up!";
	        		int duration = Toast.LENGTH_SHORT;

	        		Toast toast = Toast.makeText(context, text, duration);
	        		toast.show();

	    		} catch (IOException e) {   
					// TODO Auto-generated catch block
					e.printStackTrace();
	    		}
	     	}
	    });
	    
	    final Button button_restore = (Button) findViewById(R.id.button_restore);
	    button_restore.setOnClickListener(new View.OnClickListener() {
		
	    	@Override
			public void onClick(View v) {
	   			Runtime runtime = Runtime.getRuntime();
	                Process proc = null;
	                OutputStreamWriter osw = null;

	                String command="/system/bin/reboot nvrestore";

	                try { // Run Script

	                    proc = runtime.exec("su");
	                    osw = new OutputStreamWriter(proc.getOutputStream());
	                                        osw.write(command);
	                            osw.flush();
	                    osw.close();
	                    
	                    Context context = getApplicationContext();
	        		CharSequence text = "Restoring NV Backup!";
	        		int duration = Toast.LENGTH_SHORT;

	        		Toast toast = Toast.makeText(context, text, duration);
	        		toast.show();

	    		} catch (IOException ex) {   
					// TODO Auto-generated catch block
					ex.printStackTrace();
	    		}
	     	}
	    });
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nvbackup, menu);
		return true;
	}

}
