package com.now.nowtools.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.now.nowtools.R;
import com.now.nowtools.ui.activity.ocr.BankCardActivity;
import com.now.nowtools.ui.activity.ocr.GeneralActivity;
import com.now.nowtools.ui.activity.ocr.IDCardActivity;
import com.now.nowtools.ui.activity.voice.SpeakActivity;
import com.now.nowtools.ui.activity.voice.SpeechRecognitionActivity;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 作者：now on 2017/4/28 09:32
 * 邮箱：3198751771@qq.com
 */
public class OcrFragemnt extends Fragment {
    private static final String TAG = "OcrFragemnt";
    @InjectView(R.id.general_button)
    Button generalButton;
    @InjectView(R.id.idcard_button)
    Button idcardButton;
    @InjectView(R.id.bankcard_button)
    Button bankcardButton;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    @InjectView(R.id.voice_synthesis)
    Button voiceSynthesis;
    @InjectView(R.id.speech_recognition)
    Button speechRecognition;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ocr, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAccessTokenWithAkSk();
        float a = 5 / 10;
        Toast.makeText(getActivity(), a + "", Toast.LENGTH_SHORT).show();
    }

    public static OcrFragemnt newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        OcrFragemnt fragment = new OcrFragemnt();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.general_button, R.id.idcard_button, R.id.bankcard_button, R.id.speech_recognition, R.id.voice_synthesis})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.general_button:
                intent = new Intent(getActivity(), GeneralActivity.class);
                startActivity(intent);
                break;
            case R.id.idcard_button:
                intent = new Intent(getActivity(), IDCardActivity.class);
                startActivity(intent);
                break;
            case R.id.bankcard_button:
                intent = new Intent(getActivity(), BankCardActivity.class);
                startActivity(intent);
                break;
            case R.id.speech_recognition:
                intent = new Intent(getActivity(), SpeakActivity.class);
                startActivity(intent);
                break;
            case R.id.voice_synthesis:
                intent = new Intent(getActivity(), SpeechRecognitionActivity.class);
                startActivity(intent);
                break;
        }
    }


    private void initAccessTokenWithAkSk() {
        OCR.getInstance().initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                Log.e(TAG, "AK，SK方式获取token失败");
            }
        }, getActivity().getApplicationContext(), "eYQPVpeLthRkI0RGBtxaUPR6", "aLSjcMILcPza7o4aPUFiLHzRK2ny5BGU");
    }

}
