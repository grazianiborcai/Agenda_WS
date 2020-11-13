package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PersonVisiMergeToUpdate implements InfoMergerVisitor<PersonInfo, PersonInfo> {
	
	@Override public List<PersonInfo> beforeMerge(List<PersonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersonInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, PersonInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.codEntityCateg = selectedInfo.codEntityCateg;
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;		
		
		if (selectedInfo.cpf != null)
			baseInfo.cpf = selectedInfo.cpf;
		
		if (selectedInfo.email != null)
			baseInfo.email = selectedInfo.email;
		
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersonInfo> getUniquifier() {
		return null;
	}
}
