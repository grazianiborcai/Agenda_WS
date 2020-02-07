package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeFeeCateg implements InfoMergerVisitorV3<OrderInfo, FeeCategInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, FeeCategInfo selectedInfo) {
		return (baseInfo.codFeeCateg == selectedInfo.codFeeCateg);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, FeeCategInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtFeeCateg = selectedInfo.txtFeeCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
