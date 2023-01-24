package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;

final class CrecardMergerVisiCrecapa extends InfoMergerVisitorTemplate<CrecardInfo, CrecapaInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CrecapaInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CrecapaInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.creditCardId = selectedInfo.id;
		baseInfo.creditCardBrand = selectedInfo.brand;
		baseInfo.creditCardLast4 = selectedInfo.last_four_digits;
		
		results.add(baseInfo);
		return results;
	}
}
