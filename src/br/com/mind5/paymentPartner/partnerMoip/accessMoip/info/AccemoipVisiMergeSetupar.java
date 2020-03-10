package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class AccemoipVisiMergeSetupar implements InfoMergerVisitorV3<AccemoipInfo, SetuparInfo> {
	
	@Override public List<AccemoipInfo> beforeMerge(List<AccemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AccemoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<AccemoipInfo> merge(AccemoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AccemoipInfo> getUniquifier() {
		return null;
	}
}
