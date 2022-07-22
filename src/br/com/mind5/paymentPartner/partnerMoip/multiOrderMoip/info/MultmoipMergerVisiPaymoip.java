package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class MultmoipMergerVisiPaymoip extends InfoMergerVisitorTemplate<MultmoipInfo, PaymoipInfo> {

	@Override public boolean shouldMerge(MultmoipInfo baseInfo, PaymoipInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, PaymoipInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<MultmoipInfo> uniquifyHook(List<MultmoipInfo> results) {
		InfoUniquifier<MultmoipInfo> uniquifier = new MultmoipUniquifier();		
		return uniquifier.uniquify(results);
	}
}
