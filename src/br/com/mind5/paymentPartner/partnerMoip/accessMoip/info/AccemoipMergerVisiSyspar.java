package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

final class AccemoipMergerVisiSyspar extends InfoMergerVisitorTemplate<AccemoipInfo, MktparInfo> {

	@Override public boolean shouldMerge(AccemoipInfo baseInfo, MktparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<AccemoipInfo> merge(AccemoipInfo baseInfo, MktparInfo selectedInfo) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
