package blak.mvx.activities;

import blak.mvx.R;
import butterknife.Bind;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends FragmentActivity {
    @Bind(R.id.mvx__input_label)
    TextView mLabelView;

    @Bind(R.id.mvx__input_edit)
    EditText mEditView;

    @Bind(R.id.mvx__input_send)
    View mSendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvx__activity_input);
        ButterKnife.bind(this);
        initListeners();
    }

    private void initListeners() {
        mSendButton.setOnClickListener(v -> {
            String text = mEditView.getText().toString();
            mLabelView.setText(text);
        });
    }
}
