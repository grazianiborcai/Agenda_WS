package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayordemVisiMergeToUpdate extends InfoMergerVisitorTemplate<PayordemInfo, PayordemInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, PayordemInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		selectedInfo.idOrderPartner = baseInfo.idOrderPartner;
		selectedInfo.statusOrderPartner = baseInfo.statusOrderPartner;	
		selectedInfo.idPaymentPartner = baseInfo.idPaymentPartner;
		selectedInfo.statusPaymentPartner = baseInfo.statusPaymentPartner;
		selectedInfo.ownId = baseInfo.ownId;
		selectedInfo.itemReceiver = baseInfo.itemReceiver;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
