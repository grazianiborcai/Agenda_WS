package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

final class PayordemMergerVisiMktpar extends InfoMergerVisitorTemplate<PayordemInfo, MktparInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, MktparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, MktparInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.itemReceiver = selectedInfo.idPayPartnerSystem;
		
		results.add(baseInfo);
		return results;
	}
}
