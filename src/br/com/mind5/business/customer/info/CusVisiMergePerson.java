package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CusVisiMergePerson extends InfoMergerVisitorTemplate<CusInfo, PersonInfo> {
	
	@Override public List<CusInfo> beforeMerge(List<CusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusInfo baseInfo, PersonInfo selectedInfo) {
		if (baseInfo.codOwner != selectedInfo.codOwner)
			return false;
		
		if (baseInfo.codPerson <= 0)
			return true;
		
		return (baseInfo.codPerson == selectedInfo.codPerson);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, PersonInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.personData = selectedInfo;
		baseInfo.codPerson = selectedInfo.codPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusInfo> getUniquifier() {
		return null;
	}
}
