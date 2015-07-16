package com.codepath.anuscorps23.onlycoin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.anuscorps23.onlycoin.R;
import com.codepath.anuscorps23.onlycoin.helpers.ImageLoader;
import com.codepath.anuscorps23.onlycoin.models.OnlyCoinCreditCards;

import java.util.List;

/**
 * Created by anuscorps23 on 7/12/15.
 */
public class OnlyCoinAdapter  extends ArrayAdapter<OnlyCoinCreditCards> {

    private ImageLoader imgLoader;

    private static class ViewHolder
        {
            TextView tvFullName;
            TextView tvCreditCardNumber;
            TextView tvExpirationDate;
            TextView tvCreated;
            ImageView ivCard;
        }

    public OnlyCoinAdapter(Context context, List<OnlyCoinCreditCards> images) {

        super(context, R.layout.item_credit_card, images);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        OnlyCoinCreditCards card = getItem(position);
        imgLoader = new ImageLoader(getContext());

        ViewHolder viewHolder; // view lookup cache stored in tag

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_credit_card, parent, false);

            viewHolder.tvFullName = (TextView) convertView.findViewById(R.id.tvFullName);
            viewHolder.tvCreditCardNumber = (TextView) convertView.findViewById(R.id.tvCreditCardNumber);
            viewHolder.tvExpirationDate = (TextView) convertView.findViewById(R.id.tvExpirationDate);
            //viewHolder.tvCreated = (TextView) convertView.findViewById(R.id.tvCreated);
            viewHolder.ivCard = (ImageView) convertView.findViewById(R.id.ivCard);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }



        viewHolder.tvFullName.setText((card.first_name) + "  " +(card.last_name));
        viewHolder.tvCreditCardNumber.setText(card.card_number);
        viewHolder.tvExpirationDate.setText(card.expiration_date);
        //viewHolder.tvCreated.setText(card.created);

        //viewHolder.ivCard.setImageResource(0);

        // Caching comes into play here
        imgLoader.displayImage(card.background_image_url, viewHolder.ivCard);


        return convertView;
    }

}
