package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipVisiMergeOrdmoip extends InfoMergerVisitorTemplate<MultmoipInfo, OrdmoipInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		for (MultmoipInfo eachBase : baseInfos) {
			eachBase.ordmoips = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, OrdmoipInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, OrdmoipInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.ordmoips.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
