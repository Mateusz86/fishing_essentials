package pl.mateusz.drozdz.fishing_essentials.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import pl.mateusz.drozdz.fishing_essentials.core.Property;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

@SuppressLint("NewApi")
public class MyLinearLayout extends LinearLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	public MyLinearLayout(Context context) {
		super(context);
		// LayoutInflater inflater = (LayoutInflater) context
		// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// inflater.inflate(R.layout., this, true);
	}
	
	public MyLinearLayout() {
		super(Property.getContext());

	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	
	public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String encoded = null;
//		try {
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//					byteArrayOutputStream);
//			objectOutputStream.writeObject(this);
//			objectOutputStream.close();
//			
//			
//			encoded = new String(Base64.encode(byteArrayOutputStream.toByteArray()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			encoded=pl.mateusz.drozdz.fishing_essentials.core.Base64.encodeObject(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "vvv";
	}

}
