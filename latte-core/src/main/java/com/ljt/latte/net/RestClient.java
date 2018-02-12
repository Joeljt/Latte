package com.ljt.latte.net;

import com.ljt.latte.net.callback.IError;
import com.ljt.latte.net.callback.IFailure;
import com.ljt.latte.net.callback.IRequest;
import com.ljt.latte.net.callback.ISuccess;
import com.ljt.latte.net.callback.RequestCallBacks;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 14:01
 * For：网络框架
 */

public class RestClient {

    private final String URL;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IFailure failure, IError error, RequestBody body) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if(REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET :
                call = service.get(URL, PARAMS);
                break;
            case POST :
                call = service.post(URL, PARAMS);
                break;
            case PUT :
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }
        
        if(call != null) {
            call.enqueue(getRequestCallBack());
        }

    }

    private Callback<String> getRequestCallBack() {
        return new RequestCallBacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

}
