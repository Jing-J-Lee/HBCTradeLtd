package com.example.xps.hbctradeltd.c;

import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.example.xps.hbctradeltd.d.bean.ContractTypeDetailResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeResp;
import com.example.xps.hbctradeltd.d.net.AwSchedulers;
import com.example.xps.hbctradeltd.d.net.ContractApi;
import com.example.xps.hbctradeltd.d.net.RetrofitUtils;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ContractNetWork extends RetrofitUtils {
    private static ContractApi contractApi=RetrofitUtils.getContractapi();
    //查询合同类型
    public static void getContractType(String uid, Subscriber<ContractTypeResp> sub){
        contractApi.queryContractType(uid).compose(AwSchedulers.<ContractTypeResp>applySchedulers()).subscribe(sub);
    }
    //根据合同类型查询字段
    public static void getContractTypeDetail(String tid, Subscriber<ContractTypeDetailResp> sub){
        contractApi.queryContractTypeDetail(tid).compose(AwSchedulers.<ContractTypeDetailResp>applySchedulers()).subscribe(sub);
    }
    //查询合同
    public static void getContract(String uid, Subscriber<ContractList> sub){
        contractApi.queryContract(uid).compose(AwSchedulers.<ContractList>applySchedulers()).subscribe(sub);
    }

}
