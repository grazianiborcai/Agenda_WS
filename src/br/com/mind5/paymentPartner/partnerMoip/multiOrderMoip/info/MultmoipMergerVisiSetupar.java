package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class MultmoipMergerVisiSetupar extends InfoMergerVisitorTemplate<MultmoipInfo, SetuparInfo> {

	@Override public boolean shouldMerge(MultmoipInfo baseInfo, SetuparInfo selectedInfo) {
		return baseInfo.codPayPartner == selectedInfo.codPayPartner;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<MultmoipInfo> uniquifyHook(List<MultmoipInfo> results) {
		InfoUniquifier<MultmoipInfo> uniquifier = new MultmoipUniquifier();		
		return uniquifier.uniquify(results);
	}
}
