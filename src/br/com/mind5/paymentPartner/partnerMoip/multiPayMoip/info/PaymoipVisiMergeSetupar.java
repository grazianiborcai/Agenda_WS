package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class PaymoipVisiMergeSetupar extends InfoMergerVisitorTemplate<PaymoipInfo, SetuparInfo> {

	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SetuparInfo selectedInfo) {
		return baseInfo.codPayPartner == selectedInfo.codPayPartner;
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
