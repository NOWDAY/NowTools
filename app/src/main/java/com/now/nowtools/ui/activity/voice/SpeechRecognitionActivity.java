package com.now.nowtools.ui.activity.voice;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.now.nowtools.R;
import com.now.nowtools.utils.BaiDuTTSManager;
import com.now.nowtools.utils.ToastUtils;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：now on 2017/5/11 14:52
 * 邮箱：3198751771@qq.com
 */

public class SpeechRecognitionActivity extends Activity {

    @InjectView(R.id.editText)
    EditText editText;
    @InjectView(R.id.voice_synthesis)
    Button voiceSynthesis;

    private BaiDuTTSManager baiDuTTSManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_recognition);
        ButterKnife.inject(this);
        baiDuTTSManager = new BaiDuTTSManager(this);
    }

    @OnClick(R.id.voice_synthesis)
    public void onClick() {
        String text = editText.getText().toString();
        if (!TextUtils.isEmpty(text)){
            baiDuTTSManager.speak(text);
        }else {
            ToastUtils.showToast(this,"请输出文字");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        baiDuTTSManager.destroy();//关闭百度语音
    }
}
