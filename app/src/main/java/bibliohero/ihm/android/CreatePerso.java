package bibliohero.ihm.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CreatePerso extends AppCompatActivity implements View.OnClickListener {

    Button minus1 = null;
    Button minus2 = null;
    Button minus3 = null;
    Button minus4 = null;
    Button minus5 = null;
    Button minus6 = null;
    Button minus7 = null;
    Button add1 = null;
    Button add2 = null;
    Button add3 = null;
    Button add4 = null;
    Button add5 = null;
    Button add6 = null;
    Button add7 = null;
    TextView attr1 = null;
    TextView attr2 = null;
    TextView attr3 = null;
    TextView attr4 = null;
    TextView attr5 = null;
    TextView attr6 = null;
    TextView attr7 = null;
    Spinner spinRace = null;
    Spinner spinClasse = null;
    Spinner spinSexe = null;
    Spinner spinGenre = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_perso);
        minus1 = (Button)findViewById(R.id.Minus1Attr);
        add1 = (Button)findViewById(R.id.Add1Attr);
        minus2 = (Button)findViewById(R.id.Minus2Attr);
        add2 = (Button)findViewById(R.id.Add2Attr);
        minus3 = (Button)findViewById(R.id.Minus3Attr);
        add3 = (Button)findViewById(R.id.Add3Attr);
        minus4 = (Button)findViewById(R.id.Minus4Attr);
        add4 = (Button)findViewById(R.id.Add4Attr);
        minus5 = (Button)findViewById(R.id.Minus5Attr);
        add5 = (Button)findViewById(R.id.Add5Attr);
        minus6 = (Button)findViewById(R.id.Minus6Attr);
        add6 = (Button)findViewById(R.id.Add6Attr);
        minus7 = (Button)findViewById(R.id.Minus7Attr);
        add7 = (Button)findViewById(R.id.Add7Attr);
        minus1.setOnClickListener(this);
        minus2.setOnClickListener(this);
        minus3.setOnClickListener(this);
        minus4.setOnClickListener(this);
        minus5.setOnClickListener(this);
        minus6.setOnClickListener(this);
        minus7.setOnClickListener(this);
        add1.setOnClickListener(this);
        add2.setOnClickListener(this);
        add3.setOnClickListener(this);
        add4.setOnClickListener(this);
        add5.setOnClickListener(this);
        add6.setOnClickListener(this);
        add7.setOnClickListener(this);
        attr1 = (TextView)findViewById(R.id.Attr1);
        attr2 = (TextView)findViewById(R.id.Attr2);
        attr3 = (TextView)findViewById(R.id.Attr3);
        attr4 = (TextView)findViewById(R.id.Attr4);
        attr5 = (TextView)findViewById(R.id.Attr5);
        attr6 = (TextView)findViewById(R.id.Attr6);
        attr7 = (TextView)findViewById(R.id.Attr7);
        spinRace = (Spinner)findViewById(R.id.spinnerRace);
        spinClasse = (Spinner)findViewById(R.id.spinnerClasse);
        spinSexe = (Spinner)findViewById(R.id.spinnerSexe);
        spinGenre = (Spinner)findViewById(R.id.spinnerGenre);
    }

    public void onClick(View v)
    {
        int i;
        switch(v.getId())
        {
            case R.id.Minus1Attr:
                i = Integer.getInteger(attr1.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr1.setText(String.valueOf(i));
                break;
            case R.id.Minus2Attr:
                i = Integer.getInteger(attr2.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr2.setText(String.valueOf(i));
                break;
            case R.id.Minus3Attr:
                i = Integer.getInteger(attr3.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr3.setText(String.valueOf(i));
                break;
            case R.id.Minus4Attr:
                i = Integer.getInteger(attr4.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr4.setText(String.valueOf(i));
                break;
            case R.id.Minus5Attr:
                i = Integer.getInteger(attr5.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr5.setText(String.valueOf(i));
                break;
            case R.id.Minus6Attr:
                i = Integer.getInteger(attr6.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr6.setText(String.valueOf(i));
                break;
            case R.id.Minus7Attr:
                i = Integer.getInteger(attr7.getText().toString());
                i--;
                if (i>0&&i<18)
                    attr7.setText(String.valueOf(i));
                break;
            case R.id.Add1Attr:
                i = Integer.getInteger(attr1.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr1.setText(String.valueOf(i));
                break;
            case R.id.Add2Attr:
                i = Integer.getInteger(attr2.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr2.setText(String.valueOf(i));
                break;
            case R.id.Add3Attr:
                i = Integer.getInteger(attr3.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr3.setText(String.valueOf(i));
                break;
            case R.id.Add4Attr:
                i = Integer.getInteger(attr4.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr4.setText(String.valueOf(i));
                break;
            case R.id.Add5Attr:
                i = Integer.getInteger(attr5.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr5.setText(String.valueOf(i));
                break;
            case R.id.Add6Attr:
                i = Integer.getInteger(attr6.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr6.setText(String.valueOf(i));
                break;
            case R.id.Add7Attr:
                i = Integer.getInteger(attr7.getText().toString());
                i++;
                if (i>0&&i<18)
                    attr7.setText(String.valueOf(i));
                break;
        }
    }

    public void openGameActivity(View v)
    {

        Intent intent = new Intent(this, GameActivity.class);
        getBaseContext().startActivity(intent);
    }

    public void cancelactivity(View v)
    {
        this.finish();
    }
}
