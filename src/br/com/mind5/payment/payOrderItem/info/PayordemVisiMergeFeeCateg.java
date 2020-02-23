package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PayordemVisiMergeFeeCateg implements InfoMergerVisitorV3<PayordemInfo, FeeCategInfo> {
	
	@Override public List<PayordemInfo> beforeMerge(List<PayordemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemInfo baseInfo, FeeCategInfo selectedInfo) {
		return (baseInfo.codFeeCateg == selectedInfo.codFeeCateg);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, FeeCategInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.txtFeeCateg = selectedInfo.txtFeeCateg; 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemInfo> getUniquifier() {
		return null;
	}
}
