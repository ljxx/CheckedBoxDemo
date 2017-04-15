package com.ylx.checkedboxdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListitemAdapter extends BaseAdapter {

	private List<DataHolder> mList;
	private Context mContext;
	private LayoutInflater mInflater;
	public ListitemAdapter(Context context,List<DataHolder> list){
		mList = list;
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;  
        if (convertView == null) {  
            holder=new ViewHolder();
            convertView = mInflater.inflate(R.layout.check_list_item, null);
            holder.category_name = (TextView)convertView.findViewById(R.id.category_name);
			holder.mCheckable = (CheckableFrameLayout) convertView.findViewById(R.id.mCheckable);
			convertView.setTag(holder);
              
        }else {  
            holder = (ViewHolder)convertView.getTag();
        }

		holder.mCheckable.setOnCheckedChangeListener(new CheckableFrameLayout.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CheckableFrameLayout myCheckedTextView, boolean isChecked) {
				Log.i("====onCheckedChanged===","=========" + isChecked);
			}
		});
           
        holder.category_name.setText((String)mList.get(position).subTitleStr);
        return convertView;  
	}
	
	public class ViewHolder{
		public TextView category_name;
		CheckableFrameLayout mCheckable;
	};
	
	
	

}


