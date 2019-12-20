package spksolutions.appointmentmaster.ui.card;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import spksolutions.appointmentmaster.R;

public class AIO_CARD {

	private Button fst_btn,snd_btn;
	private TextView title,sub_title;
	private ImageView image;
	private Activity activity;

	public AIO_CARD() {
		fst_btn = null;
		snd_btn = null;
		title = null;
		sub_title = null;
		image = null;
	}

	public AIO_CARD(Activity act){
		this.activity = act;
		title = activity.findViewById(R.id.text_title);
		sub_title = activity.findViewById(R.id.text_title);
		fst_btn = activity.findViewById(R.id.btn_add_to_calendar);
		snd_btn = activity.findViewById(R.id.btn_approve);
		image = activity.findViewById(R.id.header_image);

		title.setVisibility(View.GONE);
		sub_title.setVisibility(View.GONE);
		fst_btn.setVisibility(View.GONE);
		snd_btn.setVisibility(View.GONE);
		image.setVisibility(View.GONE);
	}

	public AIO_CARD(Activity activity, String titleText){
		this(activity);
		title.setText(titleText);
		title.setVisibility(View.VISIBLE);
	}

	public AIO_CARD(Activity activity, String titleText, String subTitleText){
		this(activity,titleText);
		sub_title.setText(subTitleText);
		sub_title.setVisibility(View.VISIBLE);
	}

	public AIO_CARD(Activity activity, String titleText, String subTitleText, String fst_btn_str){
		this(activity,titleText,subTitleText);
		fst_btn.setText(fst_btn_str);
		fst_btn.setVisibility(View.VISIBLE);
	}

	public AIO_CARD(Activity activity, String titleText, String subTitleText, String fst_btn_str, String snd_btn_str){
		this(activity,titleText,subTitleText,fst_btn_str);
		snd_btn.setText(snd_btn_str);
		snd_btn.setVisibility(View.VISIBLE);
	}

	public void set_title(String str){
		title.setText(str);
		title.setVisibility(View.VISIBLE);
	}

	public void set_sub_title(String str){
		sub_title.setText(str);
		sub_title.setVisibility(View.VISIBLE);
	}

	public void set_fst_btn(String str){
		fst_btn.setVisibility(View.VISIBLE);
		fst_btn.setText(str);
	}

	public void set_snd_btn(String str){
		snd_btn.setText(str);
		snd_btn.setVisibility(View.VISIBLE);
	}

	public void set_image(@DrawableRes int resource){
		image.setVisibility(View.VISIBLE);
		image.setImageResource(resource);
	}
}