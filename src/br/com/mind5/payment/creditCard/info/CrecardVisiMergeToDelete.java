package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CrecardVisiMergeToDelete extends InfoMergerVisitorTemplate<CrecardInfo, CrecardInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CrecardInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();

		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
