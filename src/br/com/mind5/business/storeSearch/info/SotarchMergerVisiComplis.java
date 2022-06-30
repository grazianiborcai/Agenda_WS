package br.com.mind5.business.storeSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SotarchMergerVisiComplis extends InfoMergerVisitorTemplate<SotarchInfo, ComplisInfo> {

	@Override public boolean shouldMerge(SotarchInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SotarchInfo> merge(SotarchInfo baseInfo, ComplisInfo selectedInfo) {
		List<SotarchInfo> results = new ArrayList<>();
		
		baseInfo.codCompany = selectedInfo.codCompany;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
