package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view) {
        display(quantity);
        String priceMessage="Total: "+quantity*5+" $\nThank you";

       CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
       boolean state = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
       boolean chocoState = chocolate.isChecked();

       EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();
//
//        displayMessage(createOrderSummary(calculatePrice(state,chocoState),state,chocoState,name));

            String body = createOrderSummary(calculatePrice(state,chocoState),state,chocoState,name);


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Order coffee to " + name);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

    }
    private void display(int number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    private int calculatePrice(boolean cream,boolean chocolate)
    {
        int oneCupPrice = 5;
        if(cream){
            oneCupPrice += 1;
        }
        if(chocolate){
            oneCupPrice += 2;
        }
        int price = quantity * oneCupPrice;
        return price;
    }
    private String createOrderSummary(int totalPrice , boolean state , boolean chocostate , String name)
    {
        String summary = "Name : "+name+" \n";
        summary += "Added whipped cream ? : " + state + "\n";
        summary += "Added Chocolate ? : " + chocostate + "\n";
        summary += "quantity : "+ quantity + "\n";
        summary += "Total Price :" + totalPrice + "$\n";
        summary += getString(R.string.ThankYou);
        return summary;
    }

    public void increment(View view) {
        if(quantity == 100) {
            Toast.makeText(this,"Can't order more than 100 cups",Toast.LENGTH_LONG).show();
            return;
        }
        else {
        quantity= quantity +1;}
        incrementQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity == 1) {
            Toast.makeText(this,"Can't order Less than 1 cup",Toast.LENGTH_LONG).show();
            return;
        }
        else {
       quantity= quantity - 1;}
        decrementQuantity(quantity);
    }

    private void incrementQuantity(int number)
    {
        TextView quantity=(TextView) findViewById(R.id.quantity_text_view);
        quantity.setText(""+number);
    }

    private void decrementQuantity(int number)
    {
        TextView quantity=(TextView) findViewById(R.id.quantity_text_view);
        quantity.setText(""+number);
    }
   /* private void displayMessage(String message)
    {
        TextView order_summary_text_view=(TextView) findViewById(R.id.order_summary_text_view);
        order_summary_text_view.setText(message);
    }*/


}
