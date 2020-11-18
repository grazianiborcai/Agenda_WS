package br.com.mind5.business.employeeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapVisiMergePersolis extends InfoMergerVisitorTemplate<EmpnapInfo, PersolisInfo> {
	
	@Override public List<EmpnapInfo> beforeMerge(List<EmpnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpnapInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner	&&
				baseInfo.codPerson == selectedInfo.codPerson	);
	}
	
	
	
	@Override public List<EmpnapInfo> merge(EmpnapInfo baseInfo, PersolisInfo selectedInfo) {
		List<EmpnapInfo> results = new ArrayList<>();
		
		baseInfo.codPersonSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpnapInfo> getUniquifier() {
		return new EmpnapUniquifier();
	}
}
