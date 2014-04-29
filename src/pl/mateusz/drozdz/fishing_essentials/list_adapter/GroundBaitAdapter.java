package pl.mateusz.drozdz.fishing_essentials.list_adapter;

import java.util.List;

import pl.mateusz.drozdz.fishing_essantials.interfaces.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class GroundBaitAdapter extends BaseAdapter {
	
	private List<GroundBait> groundList;
	private Context context;
	private LayoutInflater layoutInflater;
    private OnClickListener listener;

	WhichFragmentClick whichFragmentClickListener;
	
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
		holder.updateImgHolder= (ImageButton) convertView.findViewById(R.id.update);
		holder.deleteImgHolder = (ImageButton) convertView.findViewById(R.id.delete);
		convertView.setTag(holder);
		}
		else {
		holder= (ViewHolderGrounds) convertView.getTag();	
		}
		if(groundList.size()!=0) {
		holder.holderName.setText(groundList.get(position).getName()+" ground");
		holder.holderDescription.setText(groundList.get(position).getDescription()+"");	
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

	static class  ViewHolderGrounds {
		TextView holderName;
		TextView holderDescription;
		ImageButton updateImgHolder;
		ImageButton deleteImgHolder;
	}
	
	public List<GroundBait> getGroundList() {
		return groundList;
	}

	public void setGroundList(List<GroundBait> groundList) {
		this.groundList = groundList;
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
