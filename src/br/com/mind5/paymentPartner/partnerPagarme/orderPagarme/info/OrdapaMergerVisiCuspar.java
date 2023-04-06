package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class OrdapaMergerVisiCuspar extends InfoMergerVisitorTemplate<OrdapaInfo, CusparInfo> {

	@Override public boolean shouldMerge(OrdapaInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner    &&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<OrdapaInfo> merge(OrdapaInfo baseInfo, CusparInfo selectedInfo) {
		List<OrdapaInfo> results = new ArrayList<>();
		
		baseInfo.customerId = selectedInfo.customerId;
		
		results.add(baseInfo);
		return results;
	}
}
