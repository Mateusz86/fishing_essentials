package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.FishesListAdapter.ViewHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFishesRecordAdapter extends BaseAdapter {

	private List<CaughtFish> listData;

	private LayoutInflater layoutInflater;
	private Context context;

	public MyFishesRecordAdapter(Context context, List<CaughtFish> coughtFishes) {
		this.listData = coughtFishes;
		this.context = context;
		layoutInflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return listData.size();

	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
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
			convertView = layoutInflater.inflate(
					R.layout.list_view_fishes_item, null);
			holder = new ViewHolder();
			holder.headlineView = (TextView) convertView
					.findViewById(R.id.title);
			holder.dataAndPlaces = (TextView) convertView
					.findViewById(R.id.my_records_list_data_and_places);
			holder.lengthAndWeight = (TextView) convertView
					.findViewById(R.id.my_records_list_length_and_weight);
			holder.handleImageView = (ImageView) convertView
					.findViewById(R.id.fish_item_photo);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.headlineView.setText((listData.get(position).getFishes()
				.getName()));

		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");

		String plcesName;
		if (listData.get(position).getFishing().getPlaces() != null) {
			plcesName = listData.get(position).getFishing().getPlaces()
					.getName();
		} else {
			plcesName = "";
		}

		System.out.println(holder.dataAndPlaces);
		 holder.dataAndPlaces.setText(sf.format(listData.get(position).getDate())+" "+plcesName);

		holder.lengthAndWeight.setText(listData.get(position).getFishLength()
				+ "cm " + listData.get(position).getWeight() + "kg");
		
		InputStream ims;
		try {
			String[] f = listData.get(position).getPhotos().split("#");
			if (f.length >= 1) {
				if (!f[0].equals("empty")) {
					ims = this.context.getAssets().open(
							Property.CAUGHT_FISH_PHOTO_DIR + f[0]);
					Drawable d = Drawable.createFromStream(ims, null);
					holder.handleImageView.setImageDrawable(d);
					f[0] = null;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return convertView;
	}

	static class ViewHolder {
		TextView headlineView;
		TextView dataAndPlaces;
		TextView lengthAndWeight;
		ImageView handleImageView;
	}
}
