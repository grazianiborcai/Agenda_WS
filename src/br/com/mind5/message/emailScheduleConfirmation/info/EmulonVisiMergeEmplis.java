package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmulonVisiMergeEmplis implements InfoMergerVisitor<EmulonInfo, EmplisInfo> {
	
	@Override public List<EmulonInfo> beforeMerge(List<EmulonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulonInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	||
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<EmulonInfo> merge(EmulonInfo baseInfo, EmplisInfo selectedInfo) {
		List<EmulonInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulonInfo> getUniquifier() {
		return null;
	}
}
