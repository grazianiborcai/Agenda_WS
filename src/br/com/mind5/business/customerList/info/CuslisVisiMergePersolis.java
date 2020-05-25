package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;


final class CuslisVisiMergePersolis implements InfoMergerVisitorV3<CuslisInfo, PersolisInfo> {
	
	@Override public List<CuslisInfo> beforeMerge(List<CuslisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CuslisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner	&&
				baseInfo.codPerson == selectedInfo.codPerson);
	}
	
	
	
	@Override public List<CuslisInfo> merge(CuslisInfo baseInfo, PersolisInfo selectedInfo) {
		List<CuslisInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CuslisInfo> getUniquifier() {
		return null;
	}
}
