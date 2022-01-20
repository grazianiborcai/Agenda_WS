package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergeCuslis extends InfoMergerVisitorTemplate<PetInfo, CuslisInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, CuslisInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
