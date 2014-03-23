package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GroundBaitAdapter extends BaseAdapter {
	
	private List<GroundBait> groundList;
	private Context context;
	private LayoutInflater layoutInflater;
	
	public GroundBaitAdapter(Context context,List<GroundBait> list) {
		this.context=context;
		this.groundList=list;
		layoutInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return groundList.size();
	}

	@Override
	public Object getItem(int position) {
	    return	groundList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderGrounds holder;
		
		if(convertView==null) {
		holder = new ViewHolderGrounds();
		convertView= layoutInflater.inflate(R.layout.list_view_ground_bait_item, null);	
		holder.holderName=(TextView) convertView.findViewById(R.id.name);
		holder.holderDescription=(TextView) convertView.findViewById(R.id.description);
		convertView.setTag(holder);
		}
		else {
		holder= (ViewHolderGrounds) convertView.getTag();	
		}
		if(groundList.size()!=0) {
		holder.holderDescription.setText(groundList.get(position).getName()+"");
		holder.holderDescription.setText(groundList.get(position).getDescription()+"");
		}
		return convertView;
	}

	static class  ViewHolderGrounds {
		TextView holderName;
		TextView holderDescription;
	}
	
	public List<GroundBait> getGroundList() {
		return groundList;
	}

	public void setGroundList(List<GroundBait> groundList) {
		this.groundList = groundList;
	}
	
	

}
