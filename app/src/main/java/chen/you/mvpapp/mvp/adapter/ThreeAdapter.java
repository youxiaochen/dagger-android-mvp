package chen.you.mvpapp.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import chen.you.mvpapp.R;

/**
 * Created by You on 2019/1/19.
 */

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.ViewHolder> {

    private List<String> arrayList;

    private Context context;

    @Inject
    public ThreeAdapter(Context context) {
        arrayList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_three_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int i) {
        vh.tv.setText(arrayList.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }


    public void addDatas(ArrayList<String> arrayList) {
        this.arrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

}
