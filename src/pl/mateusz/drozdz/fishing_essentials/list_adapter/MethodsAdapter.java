package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MethodsAdapter extends BaseAdapter {

	private Context context;
	private List<Methods> methodsList;
	private LayoutInflater layoutInflater;
    private OnClickListener listener;


	public MethodsAdapter(Context context, List<Methods> list) {
		this.methodsList = list;
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return methodsList.size();
	}

	@Override
	public Object getItem(int position) {
		return methodsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderMethods holder;
		if (convertView == null) {
			holder = new ViewHolderMethods();
			convertView = layoutInflater.inflate(
					R.layout.list_view_method_item, null);
			holder.holderName = (TextView) convertView.findViewById(R.id.name);
			holder.holderDescription = (TextView) convertView
					.findViewById(R.id.description);
			holder.holderPhoto = (ImageView) convertView
					.findViewById(R.id.photo);
			 holder.updateImgHolder= (ImageButton) convertView.findViewById(R.id.update);
			 holder.deleteImgHolder = (ImageButton) convertView.findViewById(R.id.delete);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolderMethods) convertView.getTag();
		}
		if (methodsList.size() != 0) {
			holder.holderName.setText(methodsList.get(position).getName() + "method");
			holder.holderDescription.setText(methodsList.get(position)
					.getDescription() + "");

			InputStream ims;
			String photos = methodsList.get(position).getPhotos();
			if (photos != null) {
				String[] f = photos.split("#");
				if (f.length >= 1) {
					try {
						System.out.println("ph"+Property.METHODS_PHOTO_DIR + f[0]);
						ims = this.context.getAssets().open(
								Property.METHODS_PHOTO_DIR + f[0]);
						Drawable d = Drawable.createFromStream(ims, null);
						holder.holderPhoto.setImageDrawable(d);
						f[0] = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
	//		holder.updateImgHolder.setOnClickListener(listener);
	//		holder.deleteImgHolder.setOnClickListener(listener);
			
			holder.deleteImgHolder.setOnClickListener(ImgButtonListner);
			holder.updateImgHolder.setOnClickListener(ImgButtonListner);
			
			ObjectHelperPositionList helper = new ObjectHelperPositionList();
			helper.setPosition(position);
			holder.updateImgHolder.setTag(helper);
			holder.deleteImgHolder.setTag(helper);
		}

		return convertView;
	}

	static class ViewHolderMethods {
		TextView holderName;
		TextView holderDescription;
		ImageView holderPhoto;
		ImageButton updateImgHolder;
		ImageButton deleteImgHolder;
	}

	public List<Methods> getMethodsList() {
		return methodsList;
	}

	public void setMethodsList(List<Methods> methodsList) {
		this.methodsList = methodsList;
	}

	public OnClickListener getListener() {
		return listener;
	}

	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
 OnClickListener ImgButtonListner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
				listener.onClick(v);
		}
	};
	
}
