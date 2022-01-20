package br.com.mind5.business.petSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetarchVisiMergeCuslis extends InfoMergerVisitorTemplate<PetarchInfo, CuslisInfo> {

	@Override public boolean shouldMerge(PetarchInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<PetarchInfo> merge(PetarchInfo baseInfo, CuslisInfo selectedInfo) {
		List<PetarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
