package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmplisVisiMergePersolis implements InfoMergerVisitorV3<EmplisInfo, PersolisInfo> {
	
	@Override public List<EmplisInfo> beforeMerge(List<EmplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, PersolisInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplisInfo> getUniquifier() {
		return null;
	}
}
