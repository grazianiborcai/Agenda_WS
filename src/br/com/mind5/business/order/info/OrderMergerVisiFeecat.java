package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

final class OrderMergerVisiFeecat extends InfoMergerVisitorTemplate<OrderInfo, FeecatInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, FeecatInfo selectedInfo) {
		return (baseInfo.codFeeCateg == selectedInfo.codFeeCateg);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, FeecatInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtFeeCateg = selectedInfo.txtFeeCateg;
		
		results.add(baseInfo);
		return results;
	}
}
