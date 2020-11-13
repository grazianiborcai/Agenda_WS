package br.com.mind5.masterData.dayParting.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

final class DaypartVisiMergeDayparch implements InfoMergerVisitor<DaypartInfo, DayparchInfo> {
	
	@Override public List<DaypartInfo> beforeMerge(List<DaypartInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(DaypartInfo baseInfo, DayparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<DaypartInfo> merge(DaypartInfo baseInfo, DayparchInfo selectedInfo) {
		List<DaypartInfo> results = new ArrayList<>();
		
		DaypartInfo result = DaypartInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<DaypartInfo> getUniquifier() {
		return null;
	}
}
