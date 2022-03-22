package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;


final class CuslisMergerVisiPersolis extends InfoMergerVisitorTemplate<CuslisInfo, PersolisInfo> {

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
}
