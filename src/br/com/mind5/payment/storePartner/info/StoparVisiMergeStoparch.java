package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoparVisiMergeStoparch implements InfoMergerVisitorV3<StoparInfo, StoparchInfo> {
	
	@Override public List<StoparInfo> beforeMerge(List<StoparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparInfo baseInfo, StoparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, StoparchInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		StoparInfo result = new StoparInfo();
		
		result = StoparInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparInfo> getUniquifier() {
		return null;
	}
}
