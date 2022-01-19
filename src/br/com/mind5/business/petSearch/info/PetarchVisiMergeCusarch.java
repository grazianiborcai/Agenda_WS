package br.com.mind5.business.petSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetarchVisiMergeCusarch extends InfoMergerVisitorTemplate<PetarchInfo, CusarchInfo> {

	@Override public boolean shouldMerge(PetarchInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<PetarchInfo> merge(PetarchInfo baseInfo, CusarchInfo selectedInfo) {
		List<PetarchInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
