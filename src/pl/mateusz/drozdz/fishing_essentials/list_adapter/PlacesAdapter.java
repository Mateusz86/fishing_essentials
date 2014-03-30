package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PlacesAdapter extends BaseAdapter {
	
	private List<Places> placesList;
	private Context context;
	private LayoutInflater layoutInflater;

	public PlacesAdapter(Context context,List<Places> places ){
		this.context=context;
		this.placesList=places;
		this.layoutInflater=LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return placesList.size();
	}

	@Override
	public Object getItem(int position) {
		return placesList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null) {
			convertView=layoutInflater.inflate(R.layout.list_view_places_item, null);
			holder= new ViewHolder();
			holder.holderName= (TextView) convertView.findViewById(R.id.name);
			holder.holderDescription=(TextView) convertView.findViewById(R.id.description);
			convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		if(placesList.size()!=0) {
			holder.holderName.setText(placesList.get(position).getName()+"");
			holder.holderDescription.setText(placesList.get(position).getDescription()+"");
		}
		
		
		return convertView;
	}

	static class ViewHolder{
		TextView holderName;
		TextView holderDescription;
	}
	
	public List<Places> getPlacesList() {
		return placesList;
	}

	public void setPlacesList(List<Places> placesList) {
		this.placesList = placesList;
	}

	
	
}
