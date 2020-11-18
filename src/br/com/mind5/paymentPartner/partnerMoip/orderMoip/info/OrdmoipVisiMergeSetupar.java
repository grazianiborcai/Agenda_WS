package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class OrdmoipVisiMergeSetupar extends InfoMergerVisitorTemplate<OrdmoipInfo, SetuparInfo> {
	
	@Override public List<OrdmoipInfo> beforeMerge(List<OrdmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdmoipInfo> getUniquifier() {
		return null;
	}
}
