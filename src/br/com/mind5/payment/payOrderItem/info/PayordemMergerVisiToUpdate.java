package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayordemMergerVisiToUpdate extends InfoMergerVisitorTemplate<PayordemInfo, PayordemInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, PayordemInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		selectedInfo.ownId                = baseInfo.ownId;
		selectedInfo.username             = baseInfo.username;
		selectedInfo.codLanguage          = baseInfo.codLanguage;
//		selectedInfo.itemReceiver         = baseInfo.itemReceiver;
		selectedInfo.idOrderPartner       = baseInfo.idOrderPartner;
		selectedInfo.idPaymentPartner     = baseInfo.idPaymentPartner;
		selectedInfo.statusOrderPartner   = baseInfo.statusOrderPartner;		
		selectedInfo.statusPaymentPartner = baseInfo.statusPaymentPartner;
		
		results.add(selectedInfo);
		return results;
	}
}
