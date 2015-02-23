package com.promed.gridtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Integer[] imageIDs = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        int a;
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GridView gridView = (GridView) findViewById(R.id.gridview);
        //gridView.setAdapter(new ImageAdapter(this));
        gridView.setAdapter(new TextBoxAdapter(this));
        
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, 
            View v, int position, long id) 
            {                
                Toast.makeText(getBaseContext(), 
                        "pic" + (position + 1) + " selected", 
                        Toast.LENGTH_SHORT).show();
            }
        });        
    }
    
    public class TextBoxAdapter extends BaseAdapter {

    	private Context context;
		
        public TextBoxAdapter(Context c) 
        {
            context = c;
        }
        
    	@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 18;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View convertView, ViewGroup arg2) {
	        TextView textView;
	            if (convertView == null) {
	            	textView = new TextView(context);
	            	textView.setLayoutParams(new GridView.LayoutParams(185, 185));
	            	textView.setBackgroundColor(0x0033b5e5);
	            	textView.setPadding(10, 10, 10, 10);
	            } else {
	               // imageView = (ImageView) convertView;
	            	textView = new TextView(context);
	            	textView.setLayoutParams(new GridView.LayoutParams(185, 185));
	            	textView.setBackgroundColor(Color.BLUE);
	            	textView.setPadding(10, 10, 10, 10);
	            }
	            //imageView.setImageResource(imageIDs[position]);
	            return textView;
	        }		
    	
    }
    
    
    
    public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
 
        public ImageAdapter(Context c) 
        {
            context = c;
        }
 
        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }
 
        //---returns the ID of an item--- 
        public Object getItem(int position) {
            return position;
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) 
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }
    }    
}