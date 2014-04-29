package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.FishesListAdapter.ViewHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CaughtFishesListAdapter<E>  extends BaseAdapter {
	
	private static List<CaughtFish> caughtFishesList;
	private static LayoutInflater layoutInflater;
	
	
    public CaughtFishesListAdapter(Context context, List<CaughtFish> caughtFishesList) {
    	this.caughtFishesList = caughtFishesList;
		layoutInflater = LayoutInflater.from(context);
	}
	
	
	@Override
	public int getCount() {
		return caughtFishesList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return caughtFishesList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_view_caught_fishes_item, null);
			holder = new ViewHolder();
			holder.caughtfish_name = (TextView) convertView
					.findViewById(R.id.caughtfish_name);
			holder.caughtfish_date = (TextView) convertView
					.findViewById(R.id.caughtfish_date);
			holder.caughtfish_length = (TextView) convertView
					.findViewById(R.id.caughtfish_length);
			holder.caughtfish_weight = (TextView) convertView
					.findViewById(R.id.caughtfish_weight);
			holder.handleImageView = (ImageView) convertView
					.findViewById(R.id.fish_item_photo);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

//		holder.headlineView.setText((listData.get(position).getName()));
//		InputStream ims;
//		try {
//			String[] f = listData.get(position).getPhotos().split("#");
//			if (f.length >= 1) {
//				if (!f[0].equals("empty")) {
//					ims = this.context.getAssets().open(Property.FISH_PHOTO_DIR + f[0]);
//					Drawable d = Drawable.createFromStream(ims, null);
//					holder.handleImageView.setImageDrawable(d);
//					f[0]=null;
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return convertView;
	}

	static class ViewHolder {
		ImageView handleImageView;
		TextView caughtfish_name;
		TextView caughtfish_date;
		TextView caughtfish_length;
		TextView caughtfish_weight;
	}

}
