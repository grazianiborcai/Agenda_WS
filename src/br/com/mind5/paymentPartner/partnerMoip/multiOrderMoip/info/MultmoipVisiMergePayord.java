package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class MultmoipVisiMergePayord implements InfoMergerVisitorV3<MultmoipInfo, PayordInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, PayordInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.payordData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
