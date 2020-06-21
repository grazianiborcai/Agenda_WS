package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergePerson implements InfoMergerVisitorV3<OwnerInfo, PersonInfo> {
	
	@Override public List<OwnerInfo> beforeMerge(List<OwnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnerInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, PersonInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		baseInfo.personData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnerInfo> getUniquifier() {
		return new OwnerUniquifier();
	}
}
