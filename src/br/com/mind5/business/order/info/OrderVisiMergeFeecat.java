package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

final class OrderVisiMergeFeecat implements InfoMergerVisitorV3<OrderInfo, FeecatInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, FeecatInfo selectedInfo) {
		return (baseInfo.codFeeCateg == selectedInfo.codFeeCateg);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, FeecatInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtFeeCateg = selectedInfo.txtFeeCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
