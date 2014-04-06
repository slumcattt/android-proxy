package com.lechucksoftware.proxy.proxysettings.feedbackutils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.lechucksoftware.proxy.proxysettings.App;

import java.net.URI;

import be.shouldit.proxy.lib.APL;
import be.shouldit.proxy.lib.APLConstants;
import be.shouldit.proxy.lib.ProxyConfiguration;
import be.shouldit.proxy.lib.utils.ProxyUtils;

public class ApplicationSubmitService extends IntentService 
{
	public static String TAG = "ApplicationSubmitService";
	
    public ApplicationSubmitService() 
    {
        super("ApplicationSubmitService");
    }
 
    @Override
    protected void onHandleIntent(Intent intent) 
    {
    	PInfo appInfo = (PInfo) intent.getSerializableExtra("appInfo");
        SubmitApplicationFeedback(getApplicationContext(),appInfo);
    }
    
    @Override
    public void onDestroy() 
    {
        App.getLogger().d(TAG, "ApplicationSubmitService destroying");
    }
    
	/**
	 * @param context
	 */
	public void SubmitApplicationFeedback(Context context, PInfo appInfo) 
	{
		try
        {
			ProxyConfiguration proxyConf = APL.getCurrentHttpProxyConfiguration();
    		URI uri = URI.create("");
			String result = ProxyUtils.getURI(uri, proxyConf.getProxy(), APLConstants.DEFAULT_TIMEOUT);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
	}
}