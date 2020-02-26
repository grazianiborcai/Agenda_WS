package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayordVisiMergeMultmoip implements InfoMergerVisitorV3<PayordInfo, MultmoipInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, MultmoipInfo selectedInfo) {
		return (baseInfo.codOwner 	 	== selectedInfo.codOwner		&&
				baseInfo.codPayOrder  	== selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, MultmoipInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.idOrderPartner = selectedInfo.idOrderPartner;
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		baseInfo.amountTotalPartner = selectedInfo.amountTotalPartner;
		baseInfo.amountCurrencyPartner = selectedInfo.amountCurrencyPartner;	
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
