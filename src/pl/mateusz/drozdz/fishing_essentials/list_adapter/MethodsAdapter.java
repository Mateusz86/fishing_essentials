package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MethodsAdapter extends BaseAdapter{
	
	private Context context;
	private List<Methods> methodsList;
	private LayoutInflater layoutInflater;
	
	public MethodsAdapter(Context context,List<Methods> list) {
		this.methodsList=list;
		this.context=context;
		this.layoutInflater=LayoutInflater.from(context);
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
		ViewHolder holder;
		if(convertView==null) {
			holder= new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.list_view_method_item, null);
			holder.holderName= (TextView) convertView.findViewById(R.id.name);
			holder.holderDescription=(TextView) convertView.findViewById(R.id.description);
			holder.holderPhoto= (ImageView) convertView.findViewById(R.id.photo);
			convertView.setTag(holder);
		}
		else {
			holder=(ViewHolder) convertView.getTag();
		}
		if(methodsList.size()!=0) {
		holder.holderName.setText(methodsList.get(position).getName()+"");
		holder.holderDescription.setText(methodsList.get(position).getDescription()+"");
		
/*		InputStream ims;
		String[] f = methodsList.get(position).getPhotos().split("#");
		if(f.length>=1) {
			try {
				ims = this.context.getAssets().open(Property.FISH_PHOTO_DIR + f[0]);
				Drawable d = Drawable.createFromStream(ims, null);
				holder.holderPhoto.setImageDrawable(d);
				f[0]=null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	}*/
		}
		
		
		return convertView;
	}
	
	static class ViewHolder {
		TextView holderName;
		TextView holderDescription;
		ImageView holderPhoto;
	}

	public List<Methods> getMethodsList() {
		return methodsList;
	}

	public void setMethodsList(List<Methods> methodsList) {
		this.methodsList = methodsList;
	}

	
	
	
}
