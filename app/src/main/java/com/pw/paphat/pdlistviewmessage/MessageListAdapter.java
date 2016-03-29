package com.pw.paphat.pdlistviewmessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by paphat on 3/29/2016 AD.
 */
public class MessageListAdapter extends ArrayAdapter<Message> {
    private Context ctx;
    public ArrayList<Message> messageListArray;
    String[] separated;

    public MessageListAdapter(Context context, int textViewResourceId,
                              ArrayList<Message> messageListArray) {
        super(context, textViewResourceId);
        this.messageListArray = messageListArray;
        this.ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View convertView1 = convertView;
        if (convertView1 == null) {
            holder = new Holder();
            LayoutInflater vi = (LayoutInflater) ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView1 = vi.inflate(R.layout.message_list_item, null);
            holder.messageTo = (TextView) convertView1.findViewById(R.id.txt_msgTO);
            holder.messageContent = (TextView) convertView1.findViewById(R.id.txt_messageContent);
            convertView1.setTag(holder);
        } else {
            holder = (Holder) convertView1.getTag();
        }
        final Message message = getItem(position);

        holder.messageTo.setText(message.messageNumber + " : ");

        holder.messageContent.setText(message.messageContent);
        holder.messageContent.setOnClickListener(new View.OnClickListener() { //T sensor check onclick
            @Override
            public void onClick(View v) {
                String string = message.messageContent;
                separated = string.split(",");
                //separated[0];
                //separated[1];
                //int selectedIndex = (int) v.getTag(R.id.txt_messageContent);
                //Toast.makeText(v.getContext(),"" + string,Toast.LENGTH_LONG).show();

                Toast.makeText(v.getContext(), "Lat: " + separated[0] + "Lng: " + separated[1], Toast.LENGTH_LONG).show();
                //String youtubeID = youtubeResult.getYoutubes().get(selectedIndex).getId();
                //YouTubeApp.startVideo(getActivity(),youtubeID);

            }
        });

        return convertView1;
    }

    @Override
    public int getCount() {
        return messageListArray.size();
    }

    @Override
    public Message getItem(int position) {
        return messageListArray.get(position);
    }

    public void setArrayList(ArrayList<Message> messageList) {
        this.messageListArray = messageList;
        notifyDataSetChanged();
    }

    private class Holder {
        public TextView messageTo, messageContent;
    }

}