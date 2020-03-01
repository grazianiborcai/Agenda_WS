package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StoparnapVisiMergePaypar implements InfoMergerVisitorV3<StoparnapInfo, PayparInfo> {
	
	@Override public List<StoparnapInfo> beforeMerge(List<StoparnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparnapInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<StoparnapInfo> merge(StoparnapInfo baseInfo, PayparInfo selectedInfo) {
		List<StoparnapInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner; 
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparnapInfo> getUniquifier() {
		return null;
	}
}
