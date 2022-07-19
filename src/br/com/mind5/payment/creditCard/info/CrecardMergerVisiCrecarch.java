package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

final class CrecardMergerVisiCrecarch extends InfoMergerVisitorTemplate<CrecardInfo, CrecarchInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CrecarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CrecarchInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();		
		CrecardInfo result;
		
		result = CrecardInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
