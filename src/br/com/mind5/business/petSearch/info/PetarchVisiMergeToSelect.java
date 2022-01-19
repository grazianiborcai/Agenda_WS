package br.com.mind5.business.petSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetarchVisiMergeToSelect extends InfoMergerVisitorTemplate<PetarchInfo, PetarchInfo> {

	@Override public boolean shouldMerge(PetarchInfo baseInfo, PetarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<PetarchInfo> merge(PetarchInfo baseInfo, PetarchInfo selectedInfo) {
		List<PetarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
