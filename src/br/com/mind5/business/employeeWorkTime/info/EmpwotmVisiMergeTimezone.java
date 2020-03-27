package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmVisiMergeTimezone implements InfoMergerVisitorV3<EmpwotmInfo, TimezoneInfo> {
	
	@Override public List<EmpwotmInfo> beforeMerge(List<EmpwotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone)	&&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage)		);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, TimezoneInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpwotmInfo> getUniquifier() {
		return null;
	}
}
