package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecapaMergerVisiCuspar extends InfoMergerVisitorTemplate<CrecapaInfo, CusparInfo> {

	@Override public boolean shouldMerge(CrecapaInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<CrecapaInfo> merge(CrecapaInfo baseInfo, CusparInfo selectedInfo) {
		List<CrecapaInfo> results = new ArrayList<>();
		
		baseInfo.customerId = selectedInfo.customerId;
		
		results.add(baseInfo);
		return results;
	}
}
