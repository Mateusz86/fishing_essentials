package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FishesListAdapter extends BaseAdapter {

	private List<Fishes> listData;

	private LayoutInflater layoutInflater;

	private Context context;

	public FishesListAdapter(Context context, List<Fishes> listData) {
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
		this.context = context;
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
			holder.handleImageView = (ImageView) convertView
					.findViewById(R.id.fish_item_photo);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.headlineView.setText((listData.get(position).getName()));
		InputStream ims;
		try {
			String[] f = listData.get(position).getPhotos().split("#");
			if (f.length >= 1) {
				if (!f[0].equals("empty")) {
					ims = this.context.getAssets().open(Property.FISH_PHOTO_DIR + f[0]);
					Drawable d = Drawable.createFromStream(ims, null);
					holder.handleImageView.setImageDrawable(d);
					f[0]=null;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return convertView;
	}

	static class ViewHolder {
		TextView headlineView;
		ImageView handleImageView;
	}

}
