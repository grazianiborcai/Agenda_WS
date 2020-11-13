package br.com.mind5.payment.storePartnerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class StoplisVisiMergePaypar implements InfoMergerVisitor<StoplisInfo, PayparInfo> {
	
	@Override public List<StoplisInfo> beforeMerge(List<StoplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoplisInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner	== selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<StoplisInfo> merge(StoplisInfo baseInfo, PayparInfo selectedInfo) {
		List<StoplisInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner; 
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoplisInfo> getUniquifier() {
		return null;
	}
}
