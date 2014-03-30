package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyExpeditionAdapter extends BaseAdapter {

	private List<Fishing> listData;

	private LayoutInflater layoutInflater;

	public MyExpeditionAdapter(Context context, List<Fishing> listData) {
		this.listData = listData;
		layoutInflater = LayoutInflater.from(context);
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
            convertView = layoutInflater.inflate(R.layout.list_view_my_expedition_item, null);
            holder = new ViewHolder();
            
            holder.title =(TextView) convertView.findViewById(R.id.title);
            holder.dataAndPlaces = (TextView) convertView.findViewById(R.id.records_list_data_and_places);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(listData.get(position).getPlaces().getName()+"");
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
		
		holder.dataAndPlaces.setText(sf.format(listData.get(position).getDate())+" ");

 
        return convertView;
	}

    static class ViewHolder {
    	TextView title;
    	TextView dataAndPlaces;
    }
}

