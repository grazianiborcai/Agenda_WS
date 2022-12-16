package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

final class OrdmoipMergerVisiSyspar extends InfoMergerVisitorTemplate<OrdmoipInfo, MktparInfo> {

	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, MktparInfo selectedInfo) {
		return (baseInfo.cusparData.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, MktparInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
