package br.com.mind5.business.customerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusarchMergerVisiPerarch extends InfoMergerVisitorTemplate<CusarchInfo, PerarchInfo> {

	@Override public boolean shouldMerge(CusarchInfo baseInfo, PerarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusarchInfo> merge(CusarchInfo baseInfo, PerarchInfo selectedInfo) {
		List<CusarchInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
