package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlacesAdapter extends BaseAdapter {
	
	private List<Places> placesList;
	private Context context;
	private LayoutInflater layoutInflater;
    private OnClickListener listener;


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
			holder.updateImgHolder= (ImageButton) convertView.findViewById(R.id.update);
			holder.deleteImgHolder = (ImageButton) convertView.findViewById(R.id.delete);
			convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		if(placesList.size()!=0) {
			holder.holderName.setText(placesList.get(position).getName()+"");
			holder.holderDescription.setText(placesList.get(position).getDescription()+"");
		//	holder.updateImgHolder.setOnClickListener(listener);
		//	holder.deleteImgHolder.setOnClickListener(listener);
			
			holder.deleteImgHolder.setOnClickListener(ImgButtonListner);
			holder.updateImgHolder.setOnClickListener(ImgButtonListner);
			
			ObjectHelperPositionList helper = new ObjectHelperPositionList();
			helper.setPosition(position);
			holder.updateImgHolder.setTag(helper);
			holder.deleteImgHolder.setTag(helper);
		}
		
		
		return convertView;
	}

	static class ViewHolder{
		TextView holderName;
		TextView holderDescription;
		ImageButton updateImgHolder;
		ImageButton deleteImgHolder;
	}
	
	public List<Places> getPlacesList() {
		return placesList;
	}

	public void setPlacesList(List<Places> placesList) {
		this.placesList = placesList;
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
