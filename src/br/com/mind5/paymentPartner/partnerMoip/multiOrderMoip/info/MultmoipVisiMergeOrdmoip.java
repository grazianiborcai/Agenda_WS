package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipVisiMergeOrdmoip implements InfoMergerVisitorV3<MultmoipInfo, OrdmoipInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, OrdmoipInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, OrdmoipInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		if(baseInfo.ordmoips.contains(selectedInfo)) 
			removeElement(baseInfo, selectedInfo);		
		
		baseInfo.ordmoips.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private MultmoipInfo removeElement(MultmoipInfo baseInfo, OrdmoipInfo selectedInfo) {
		int idx = baseInfo.ordmoips.indexOf(selectedInfo);
		baseInfo.ordmoips.remove(idx);
		
		return baseInfo;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
