package br.com.mind5.business.employeeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class EmplateVisiMergeTimezone extends InfoMergerVisitorTemplate<EmplateInfo, TimezoneInfo> {
	
	@Override public List<EmplateInfo> beforeMerge(List<EmplateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmplateInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone)	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmplateInfo> merge(EmplateInfo baseInfo, TimezoneInfo selectedInfo) {
		List<EmplateInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmplateInfo> getUniquifier() {
		return null;
	}
}
