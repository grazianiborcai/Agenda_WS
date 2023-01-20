package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CustopaMergerVisiSetupar extends InfoMergerVisitorTemplate<CustopaInfo, SetuparInfo> {

	@Override public boolean shouldMerge(CustopaInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CustopaInfo> merge(CustopaInfo baseInfo, SetuparInfo selectedInfo) {
		List<CustopaInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
