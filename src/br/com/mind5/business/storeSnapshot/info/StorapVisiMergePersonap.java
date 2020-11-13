package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergePersonap implements InfoMergerVisitor<StorapInfo, PersonapInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, PersonapInfo selectedInfo) {
		return (baseInfo.codOwner   	   == selectedInfo.codOwner		&&
				baseInfo.codPerson 		   == selectedInfo.codPerson	&&
				baseInfo.codPersonSnapshot == selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, PersonapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.personData = PersonInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
