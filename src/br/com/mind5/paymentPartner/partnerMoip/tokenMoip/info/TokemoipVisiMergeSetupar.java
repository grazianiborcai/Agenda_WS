package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class TokemoipVisiMergeSetupar implements InfoMergerVisitor<TokemoipInfo, SetuparInfo> {
	
	@Override public List<TokemoipInfo> beforeMerge(List<TokemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(TokemoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<TokemoipInfo> merge(TokemoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<TokemoipInfo> getUniquifier() {
		return null;
	}
}
