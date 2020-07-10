package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class OrdmoipCopyMultmoipToPlace extends InfoCopierOneToManyTemplate<OrdmoipInfo, MultmoipInfo> {
	
	public OrdmoipCopyMultmoipToPlace() {
		super();
	}
	
	
	
	@Override protected List<OrdmoipInfo> makeCopyHook(MultmoipInfo source) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(PayordemistInfo eachPayordemist : source.payordemists) {
			OrdmoipInfo oneResult = new OrdmoipInfo();
			
			oneResult.codOwner = eachPayordemist.codOwner;
			oneResult.codPayOrder = eachPayordemist.codPayOrder;
			oneResult.codPayOrderItem = eachPayordemist.codPayOrderItem;
			oneResult.codLanguage = eachPayordemist.codLanguage;
			oneResult.username = eachPayordemist.username;	
			
			results.add(oneResult);
		}
		
		
		return results;
	}
}
