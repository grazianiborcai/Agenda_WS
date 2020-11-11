package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

final class StoparVisiMergeStoparnap implements InfoMergerVisitorV3<StoparInfo, StoparnapInfo> {
	
	@Override public List<StoparInfo> beforeMerge(List<StoparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparInfo baseInfo, StoparnapInfo selectedInfo) {
		return (baseInfo.codOwner 	  	== selectedInfo.codOwner		&&
				baseInfo.codStore 		== selectedInfo.codStore		&&
				baseInfo.codPayPartner 	== selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, StoparnapInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparInfo> getUniquifier() {
		return null;
	}
}
