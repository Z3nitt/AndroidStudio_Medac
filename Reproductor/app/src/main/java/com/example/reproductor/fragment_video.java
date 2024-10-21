package com.example.reproductor;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_video# newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_video extends Fragment {
    private WebView video;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_video() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        video = (WebView) view.findViewById(R.id.video);

        WebSettings webSettings = video.getSettings();
        webSettings.setJavaScriptEnabled(true);//Habilita JavaScript
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);//autoplay

        //Esto hace el que video se reproduzca dentro del webview
        video.setWebChromeClient(new WebChromeClient());

        String videoHtml = "<blockquote class=\"twitter-tweet\" data-media-max-width=\"560\"><p lang=\"en\" dir=\"ltr\">Mood <a href=\"https://t.co/ax0Ld6PNyk\">pic.twitter.com/ax0Ld6PNyk</a></p>&mdash; Bee \uD83D\uDC1D \uD83C\uDDE9\uD83C\uDDF4 (@SavinTheBees) <a href=\"https://twitter.com/SavinTheBees/status/1845874467920359903?ref_src=twsrc%5Etfw\">October 14, 2024</a></blockquote> <script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>";

        video.loadData(videoHtml, "text/html", "utf-8");
        return view;
    }
}