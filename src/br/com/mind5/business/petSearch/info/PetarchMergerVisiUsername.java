package br.com.mind5.business.petSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class PetarchMergerVisiUsername extends InfoMergerVisitorTemplate<PetarchInfo, UsernameInfo> {

	@Override public boolean shouldMerge(PetarchInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<PetarchInfo> merge(PetarchInfo baseInfo, UsernameInfo selectedInfo) {
		List<PetarchInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
