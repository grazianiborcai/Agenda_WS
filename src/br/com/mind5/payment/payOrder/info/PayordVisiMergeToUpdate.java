package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PayordVisiMergeToUpdate extends InfoMergerVisitorTemplate<PayordInfo, PayordInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, PayordInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		selectedInfo.statusOrderPartner = baseInfo.statusOrderPartner;	
		selectedInfo.idPaymentPartner = baseInfo.idPaymentPartner;
		selectedInfo.statusPaymentPartner = baseInfo.statusPaymentPartner;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
