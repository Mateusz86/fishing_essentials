package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.ArrayList;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BaitAdapter extends BaseAdapter {
	
	private List<Bait> baitList;
    private LayoutInflater layoutInflater;
    private Context context;
    private OnClickListener listener;
	
	public BaitAdapter(Context context,List<Bait> baitList) {
		this.context=context;
		this.baitList=baitList;
		this.layoutInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return baitList.size();
	}

	@Override
	public Object getItem(int position) {
		return baitList.get(position);
	}

	@Override
	public long getItemId(int position) {
	    return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null) {
		   convertView = layoutInflater.inflate(R.layout.list_view_bait_item, null);
		   holder = new ViewHolder();
		   holder.nameHolder= (TextView) convertView.findViewById(R.id.name);
		   holder.descriptionHolder=(TextView) convertView.findViewById(R.id.description);
		   convertView.setTag(holder);
		}
		else {
			holder=(ViewHolder) convertView.getTag();
		}
		if(baitList.size()!=0) {
		holder.nameHolder.setText(baitList.get(position).getName()+"");
		holder.descriptionHolder.setText(baitList.get(position).getDescription()+"");
	    }
		
		return convertView;
	}
	
	static class ViewHolder {
		TextView nameHolder;
		TextView descriptionHolder;
	}
	
	public List<Bait> getBaitList() {
		return baitList;
	}
	public void setBaitList(List<Bait> baitList) {
		this.baitList = baitList;
	}

	public OnClickListener getListener() {
		return listener;
	}

	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	
	
	
}
