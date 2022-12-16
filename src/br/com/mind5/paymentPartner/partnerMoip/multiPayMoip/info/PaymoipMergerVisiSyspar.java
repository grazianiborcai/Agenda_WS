package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

final class PaymoipMergerVisiSyspar extends InfoMergerVisitorTemplate<PaymoipInfo, MktparInfo> {

	@Override public boolean shouldMerge(PaymoipInfo baseInfo, MktparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, MktparInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
