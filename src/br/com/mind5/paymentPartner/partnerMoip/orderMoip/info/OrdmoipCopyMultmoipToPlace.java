package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class OrdmoipCopyMultmoipToPlace extends InfoCopierOneToManyTemplate<OrdmoipInfo, MultmoipInfo>{
	
	public OrdmoipCopyMultmoipToPlace() {
		super();
	}
	
	
	
	@Override protected List<OrdmoipInfo> makeCopyHook(MultmoipInfo source) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(PayordemInfo eachPayordem : source.payordems) {
			OrdmoipInfo oneResult = new OrdmoipInfo();
			
			oneResult.codOwner = eachPayordem.codOwner;
			oneResult.itemNum = eachPayordem.codPayOrderItem;
			oneResult.codFeeCateg = source.codFeeCateg;
			oneResult.txtFeeCateg = source.txtFeeCateg;
			oneResult.payordemData = eachPayordem;
			oneResult.cusparData = source.cusparData;
			oneResult.sysparData = source.sysparData;		
			
			results.add(oneResult);
		}
		
		
		return results;
	}
}
