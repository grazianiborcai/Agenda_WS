package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CuslisMergerVisiCusarch extends InfoMergerVisitorTemplate<CuslisInfo, CusarchInfo> {

	@Override public boolean shouldMerge(CuslisInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CuslisInfo> merge(CuslisInfo baseInfo, CusarchInfo selectedInfo) {
		List<CuslisInfo> results = new ArrayList<>();
		
		CuslisInfo result = CuslisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
