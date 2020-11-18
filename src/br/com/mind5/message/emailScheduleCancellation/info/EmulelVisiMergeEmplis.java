package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmulelVisiMergeEmplis extends InfoMergerVisitorTemplate<EmulelInfo, EmplisInfo> {
	
	@Override public List<EmulelInfo> beforeMerge(List<EmulelInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulelInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	||
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<EmulelInfo> merge(EmulelInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmulelInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulelInfo> getUniquifier() {
		return null;
	}
}
