package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;


public final class SplitapaSetterPayordem extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {
		if(hasPayordem(recordInfo) == false)
			return recordInfo;
		
		recordInfo = filterPayordem(recordInfo);		
		return recordInfo;
	}
	
	
	
	private boolean hasPayordem(SplitapaInfo recordInfo) {
		if (recordInfo.payordData == null)
			return false;
		
		if (recordInfo.payordData.payordems == null)
			return false;
		
		if (recordInfo.payordData.payordems.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private SplitapaInfo filterPayordem(SplitapaInfo recordInfo) {
		List<PayordemInfo> payordems = new ArrayList<>();
		
		for(PayordemInfo eachPayordem : recordInfo.payordData.payordems) {
			if (shouldKeep(recordInfo, eachPayordem) == true)
				payordems.add(eachPayordem);
		}
		
		recordInfo.payordData.payordems = payordems;
		return recordInfo;
	}
	
	
	
	private boolean shouldKeep(SplitapaInfo recordInfo, PayordemInfo eachPayordem) {
		return eachPayordem.codOwner        == recordInfo.codOwner    &&
			   eachPayordem.codPayOrder     == recordInfo.codPayOrder &&
			   eachPayordem.codPayOrderItem == recordInfo.codPayOrderItem;
	}
}
