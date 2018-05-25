package com.jerry.pathanimation;

import android.app.Activity;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.mcxtzhang.pathanimlib.PathAnimView;
import com.mcxtzhang.pathanimlib.utils.SvgPathParser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private Button run;
	private RelativeLayout rlt_animation_layout;
	private FllowerAnimation fllowerAnimation;
    private ListView dataLV;
	private ImageView cartIV;
	private PathAnimView storeView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		run = (Button) findViewById(R.id.but_run);
		rlt_animation_layout = (RelativeLayout) findViewById(R.id.rlt_animation_layout);
        dataLV = (ListView)findViewById(R.id.dataLV);
		cartIV = (ImageView)findViewById(R.id.cartIV);
		
		
		rlt_animation_layout.setVisibility(View.VISIBLE);
		
		fllowerAnimation = new FllowerAnimation(this);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		fllowerAnimation.setLayoutParams(params);
		rlt_animation_layout.addView(fllowerAnimation);
		
		
		run.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fllowerAnimation.startAnimation();
//				storeView3.startAnim();
			}
		});


        List list = new ArrayList();
        for(int i=0;i<50;i++){
            list.add(i+1);
        }
        BaseAdapter adapter = new ArrayAdapter(this,R.layout.item_list,list);
        dataLV.setAdapter(adapter);

		storeView3 = (PathAnimView)findViewById(R.id.storeView3);
		SvgPathParser svgPathParser = new SvgPathParser();
		try {
			Path path = svgPathParser.parsePath(getString(R.string.path));
			storeView3.setSourcePath(path);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		storeView3.getPathAnimHelper().setAnimTime(5000);
//		storeView3.startAnim();

//		AnimatedVectorDrawableCompat drawableCompat = AnimatedVectorDrawableCompat.create(this, R.drawable.vectordrawable_bg);
//		cartIV.setImageDrawable(drawableCompat);
//		drawableCompat.start();
	}


}
