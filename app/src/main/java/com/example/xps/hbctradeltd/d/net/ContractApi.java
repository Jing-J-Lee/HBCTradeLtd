package com.example.xps.hbctradeltd.d.net;

import com.example.xps.hbctradeltd.d.bean.ContractTypeDetailResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeResp;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/21.
 */

public interface ContractApi {

    @FormUrlEncoded
    @POST("contract/query_types")
    Observable<ContractTypeResp> queryContractType(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("contract/query_type_detail")
    Observable<ContractTypeDetailResp> queryContractTypeDetail(@Field("tid") String uid);
}
