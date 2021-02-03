package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergePerson extends InfoMergerVisitorTemplate<OwnerInfo, PersonInfo> {

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
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
