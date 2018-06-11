package com.example.android.miwok_starter_code;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

   // private MediaPlayer mediaPlayer;
    int mColorResourceId ;
//    public WordAdapter(Activity context, ArrayList<Word> words) {
//        super(context, 0, words);
//    }
    public WordAdapter(Activity context, ArrayList<Word> words,int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    // Ctrl + O To view override methods



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Word currentWord = getItem(position);

        View listItemView  = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

      /*  listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer = MediaPlayer.create(getContext(),currentWord.getAudioResourceId());
                mediaPlayer.start();
            }
        });*/



        //get color by id
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);
       // miwok_text_view.setBackgroundColor(color);
        miwok_text_view.setText(currentWord.getmMiwokTranslation());


        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
       // default_text_view.setBackgroundColor(color);
        default_text_view.setText(currentWord.getmDefaultTranslation());

        ImageView imageIcone = (ImageView) listItemView.findViewById(R.id.imageIcone);
        if(currentWord.hasImage())
        {
        imageIcone.setImageResource(currentWord.getImageResourceId());

        //We need it becuase if the image GONE in another state
        imageIcone.setVisibility(View.VISIBLE);
        }
        else {
            //GONE means hide the view image without any location for it
            //INVISIBLE means hide the image but stay has lacation
            imageIcone.setVisibility(View.GONE);
        }

        View textContainter = listItemView.findViewById(R.id.textContainter);
        textContainter.setBackgroundColor(color);


        return listItemView;
    }
}
