package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CuslisVisiMergeCusarch implements InfoMergerVisitorV3<CuslisInfo, CusarchInfo> {
	
	@Override public List<CuslisInfo> beforeMerge(List<CuslisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CuslisInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CuslisInfo> merge(CuslisInfo baseInfo, CusarchInfo selectedInfo) {
		List<CuslisInfo> results = new ArrayList<>();
		
		CuslisInfo result = CuslisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CuslisInfo> getUniquifier() {
		return null;
	}
}
