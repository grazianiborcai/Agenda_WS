package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

final class PayordemMergerVisiFeecat extends InfoMergerVisitorTemplate<PayordemInfo, FeecatInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, FeecatInfo selectedInfo) {
		return (baseInfo.codFeeCateg == selectedInfo.codFeeCateg);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, FeecatInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.txtFeeCateg = selectedInfo.txtFeeCateg; 
		
		results.add(baseInfo);
		return results;
	}
}
