package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;

final class CusparMergerVisiCustopa extends InfoMergerVisitorTemplate<CusparInfo, CustopaInfo> {
	@Override public boolean shouldMerge(CusparInfo baseInfo, CustopaInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CustopaInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.customerId = selectedInfo.id;
		
		results.add(baseInfo);
		return results;
	}
}
