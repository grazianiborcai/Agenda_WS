package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusnapVisiMergePerson implements InfoMergerVisitor<CusnapInfo, PersonInfo> {
	
	@Override public List<CusnapInfo> beforeMerge(List<CusnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusnapInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<CusnapInfo> merge(CusnapInfo baseInfo, PersonInfo selectedInfo) {
		List<CusnapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusnapInfo> getUniquifier() {
		return null;
	}
}
