package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class StoparnapVisiMergePaypar extends InfoMergerVisitorTemplate<StoparnapInfo, PayparInfo> {
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
}
