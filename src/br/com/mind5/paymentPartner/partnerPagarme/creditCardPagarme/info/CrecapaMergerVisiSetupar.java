package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CrecapaMergerVisiSetupar extends InfoMergerVisitorTemplate<CrecapaInfo, SetuparInfo> {

	@Override public boolean shouldMerge(CrecapaInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CrecapaInfo> merge(CrecapaInfo baseInfo, SetuparInfo selectedInfo) {
		List<CrecapaInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
