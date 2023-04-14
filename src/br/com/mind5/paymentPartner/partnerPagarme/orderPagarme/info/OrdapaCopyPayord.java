package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrdapaCopyPayord extends InfoCopierOneToManyTemplate<OrdapaInfo, PayordInfo> {
	
	public OrdapaCopyPayord() {
		super();
	}
	
	
	
	@Override protected List<OrdapaInfo> makeCopyHook(PayordInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<OrdapaInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachRecod : source.payordems) {
			OrdapaInfo newRecord = OrdapaInfo.copyFrom(source);
			
			newRecord.codOwner        = eachRecod.codOwner;
			newRecord.codPayOrder     = eachRecod.codPayOrder;
			newRecord.codPayOrderItem = eachRecod.codPayOrderItem;
			
			results.add(newRecord);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(PayordInfo source) {
		if (source.payordems == null)
			return false;
		
		if (source.payordems.isEmpty())
			return false;
		
		return true;
	}
}
