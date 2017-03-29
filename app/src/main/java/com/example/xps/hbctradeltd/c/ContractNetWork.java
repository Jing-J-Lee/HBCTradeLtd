package com.example.xps.hbctradeltd.c;

import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.example.xps.hbctradeltd.d.bean.ContractStateResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeDetailResp;
import com.example.xps.hbctradeltd.d.bean.ContractTypeResp;
import com.example.xps.hbctradeltd.d.bean.DeleteContractResp;
import com.example.xps.hbctradeltd.d.bean.NewContractResp;
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
    //创建合同
    public static void createContract(String uid,String type,String name,String title,String field,String in, Subscriber<NewContractResp> sub){
        contractApi.createContract(uid,type,name,title,field,in).compose(AwSchedulers.<NewContractResp>applySchedulers()).subscribe(sub);
    }

    //删除合同
    public static void deleteContract(String uid,String con_id ,Subscriber<DeleteContractResp> sub){
        contractApi.deleteContract(uid,con_id).compose(AwSchedulers.<DeleteContractResp>applySchedulers()).subscribe(sub);
    }
    //查询合同审批状态
    public static void queryContractState(String con_id ,Subscriber<ContractStateResp> sub){
        contractApi.queryContractState(con_id).compose(AwSchedulers.<ContractStateResp>applySchedulers()).subscribe(sub);
    }

}
