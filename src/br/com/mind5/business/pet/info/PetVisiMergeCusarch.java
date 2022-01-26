package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergeCusarch extends InfoMergerVisitorTemplate<PetInfo, CusarchInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, CusarchInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
