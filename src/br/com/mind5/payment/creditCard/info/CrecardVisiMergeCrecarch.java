package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

final class CrecardVisiMergeCrecarch implements InfoMergerVisitorV3<CrecardInfo, CrecarchInfo> {
	
	@Override public List<CrecardInfo> beforeMerge(List<CrecardInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CrecardInfo> getUniquifier() {
		return null;
	}
}
