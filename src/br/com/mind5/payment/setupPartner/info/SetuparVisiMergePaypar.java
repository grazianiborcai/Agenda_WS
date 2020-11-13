package br.com.mind5.payment.setupPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class SetuparVisiMergePaypar implements InfoMergerVisitor<SetuparInfo, PayparInfo> {
	
	@Override public List<SetuparInfo> beforeMerge(List<SetuparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SetuparInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<SetuparInfo> merge(SetuparInfo baseInfo, PayparInfo selectedInfo) {
		List<SetuparInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SetuparInfo> getUniquifier() {
		return null;
	}
}
