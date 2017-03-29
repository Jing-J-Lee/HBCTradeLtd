package com.example.xps.hbctradeltd.d.net;

import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.example.xps.hbctradeltd.d.bean.ContractStateResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeDetailResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeResp;
import com.example.xps.hbctradeltd.d.bean.DeleteContractResp;
import com.example.xps.hbctradeltd.d.bean.NewContractResp;

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
    @FormUrlEncoded
    @POST("contract/query_contract_list")
    Observable<ContractList> queryContract(@Field("uid") String uid);
    @FormUrlEncoded
    @POST("contract/create_contract")
    Observable<NewContractResp> createContract(@Field("uid") String uid, @Field("type") String type, @Field("name") String name, @Field("title") String title, @Field("field") String field, @Field("in") String in);

    @FormUrlEncoded
    @POST("contract/delete_contract")
    Observable<DeleteContractResp> deleteContract(@Field("uid") String uid, @Field("con_id") String con_id);

    @FormUrlEncoded
    @POST("contract/query_consult_state")
    Observable<ContractStateResp> queryContractState(@Field("con_id") String con_id);
    @FormUrlEncoded
    @POST("contract/update_contract")
    Observable<ContractStateResp> updateContractState(@Field("uid") String uid, @Field("type") String type, @Field("name") String name, @Field("title") String title, @Field("field") String field, @Field("in") String in);
}
