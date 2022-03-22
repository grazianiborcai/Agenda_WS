package br.com.mind5.business.customerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusarchMergerVisiPersolis extends InfoMergerVisitorTemplate<CusarchInfo, PersolisInfo> {

	@Override public boolean shouldMerge(CusarchInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner	&&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<CusarchInfo> merge(CusarchInfo baseInfo, PersolisInfo selectedInfo) {
		List<CusarchInfo> results = new ArrayList<>();
		
		baseInfo.persolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
