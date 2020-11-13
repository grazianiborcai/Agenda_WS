package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PersonVisiMergePersonap implements InfoMergerVisitor<PersonInfo, PersonapInfo> {
	
	@Override public List<PersonInfo> beforeMerge(List<PersonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersonInfo baseInfo, PersonapInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner	&&
				baseInfo.codPerson == selectedInfo.codPerson		);
	}
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, PersonapInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersonInfo> getUniquifier() {
		return null;
	}
}
