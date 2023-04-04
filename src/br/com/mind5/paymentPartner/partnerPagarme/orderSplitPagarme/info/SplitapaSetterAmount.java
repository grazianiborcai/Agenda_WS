package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;


public final class SplitapaSetterAmount extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {
		if(hasPayordem(recordInfo) == false)
			return recordInfo;
		
		recordInfo = setAmount(recordInfo);		
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
	
	
	
	private SplitapaInfo setAmount(SplitapaInfo recordInfo) {
		
		for(PayordemInfo eachPayordem : recordInfo.payordData.payordems) {
			recordInfo.amount = "0";			
			double totitem = eachPayordem.totitem * 100;
			
			if (totitem > 0) 
				recordInfo.amount = String.valueOf((int)totitem);
		}
		
		return recordInfo;
	}
}
