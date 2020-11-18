package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

final class MultmoipVisiMergePayordemist extends InfoMergerVisitorTemplate<MultmoipInfo, PayordemistInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, PayordemistInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, PayordemistInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.payordemists.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
