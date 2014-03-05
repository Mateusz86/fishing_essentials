package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyFishesRecordAdapter extends BaseAdapter {

	private List<MyFishesRecordAdapter> listData;

	private LayoutInflater layoutInflater;

	public MyFishesRecordAdapter(Context context, List<MyFishesRecordAdapter> listData) {
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
            convertView = layoutInflater.inflate(R.layout.list_view_my_record_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
 
        return convertView;
	}

    static class ViewHolder {

    }
}
