package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoparMergerVisiStoparch extends InfoMergerVisitorTemplate<StoparInfo, StoparchInfo> {
	@Override public boolean shouldMerge(StoparInfo baseInfo, StoparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, StoparchInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		StoparInfo result = StoparInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
