package com.kot32.warmenglish.util;

import android.content.Context;

import com.google.gson.Gson;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.data.NameValuePair;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.content.UrlEncodedFormBody;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class HttpTool {
	public static int GET = 0;
	public static int POST = 1;

	public static Object doRequestAndReturnObject(Context context,
			Class jasonClass, String url, HashMap<String, String> params,
			int REQUEST_TYPE) {
		LiteHttpClient client = LiteHttpClient.newApacheHttpClient(context);
		Object result = null;
		Request req = new Request(url);
		if (REQUEST_TYPE == GET)
			req.setMethod(HttpMethod.Get);
		else
			req.setMethod(HttpMethod.Post);
		req.setRetryMaxTimes(10);
		if (params != null) {
			Iterator iterator = params.keySet().iterator();
			if (REQUEST_TYPE == GET) {
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					req.addUrlParam(key, params.get(key));
				}
			} else {
				LinkedList<NameValuePair> pList = new LinkedList<NameValuePair>();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					pList.add(new NameValuePair(key, params.get(key)));
				}
				req.setHttpBody(new UrlEncodedFormBody(pList));
			}
		}
		Response res = client.execute(req);

		return new Gson().fromJson(res.getString(),jasonClass);

	}

	public static String doRequestAndReturnString(Context context, String url,
			HashMap<String, String> params, int REQUEST_TYPE) {
		try {
			LiteHttpClient client = LiteHttpClient.newApacheHttpClient(context);
			
			Request req = new Request(url);
			if (REQUEST_TYPE == GET)
				req.setMethod(HttpMethod.Get);
			else
				req.setMethod(HttpMethod.Post);
			req.setRetryMaxTimes(10);
			if (params != null) {
				Iterator iterator = params.keySet().iterator();
				if (REQUEST_TYPE == GET) {
					while (iterator.hasNext()) {
						String key = (String) iterator.next();
						req.addUrlParam(key, params.get(key));
					}
				} else {
					LinkedList<NameValuePair> pList = new LinkedList<NameValuePair>();
					while (iterator.hasNext()) {
						String key = (String) iterator.next();
						pList.add(new NameValuePair(key, params.get(key)));
					}
					req.setHttpBody(new UrlEncodedFormBody(pList));
				}
			}
			Response res = client.execute(req);
			return res.getString();
		} catch (Exception e) {
			return "";
		}

	}

}


