package br.com.mind5.business.petList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetlisVisiMergePetarch extends InfoMergerVisitorTemplate<PetlisInfo, PetarchInfo> {

	@Override public boolean shouldMerge(PetlisInfo baseInfo, PetarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PetlisInfo> merge(PetlisInfo baseInfo, PetarchInfo selectedInfo) {
		List<PetlisInfo> results = new ArrayList<>();
		PetlisInfo result = PetlisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
