package com.example.exoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class MainActivity extends AppCompatActivity {

    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
//    String videoURL = "http://blueappsoftware.in/layout_design_android_blog.mp4";
//    String videoURL = "https://r3---sn-4g5edn7y.googlevideo.com/videoplayback?id=o-AHw__w5qbNCsZPX5m4ve7NltPHUo4AOkhgbc6pyw_BiF&itag=18&source=youtube&requiressl=yes&pl=18&ei=c2XGXP2sBumO8gSCgKvADw&mime=video%2Fmp4&gir=yes&clen=7099500&ratebypass=yes&dur=82.895&lmt=1538390440436855&fvip=3&c=WEB&txp=5531432&ip=52.91.69.216&ipbits=0&expire=1556527571&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,itag,lmt,mime,mip,mm,mn,ms,mv,pl,ratebypass,requiressl,source&key=cms1&signature=3E64D945709161A4035B1C4D591CA552ABEABE30.27B1DBB699DC23225ADB666FD13BE22525FD2E36&title=%D8%A7%D9%84%D9%82%D9%86%D8%A7%D8%B5%20%D8%B4%D8%A7%D8%B1%D8%A9%20%D8%A7%D9%84%D8%A8%D8%AF%D8%A7%D9%8A%D8%A9%20%D8%B3%D8%A8%D9%8A%D8%B3%20%D8%AA%D9%88%D9%86%20%D9%82%D8%AF%D9%8A%D9%85%D8%A9&redirect_counter=1&cm2rm=sn-t0ae7z&req_id=2b4ba28c7d8aa3ee&cms_redirect=yes&mip=197.38.136.210&mm=34&mn=sn-4g5edn7y&ms=ltu&mt=1556505888&mv=m";

    String videoURL ="http://192.168.43.196/v.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player_view);
        try {


            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            Uri videoURI = Uri.parse(videoURL);

            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);

            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);
        }catch (Exception e){
            Log.e("MainAcvtivity"," exoplayer error "+ e.toString());
        }

    }
}
