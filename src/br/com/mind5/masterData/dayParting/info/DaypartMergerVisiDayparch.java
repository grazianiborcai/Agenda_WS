package br.com.mind5.masterData.dayParting.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

final class DaypartMergerVisiDayparch extends InfoMergerVisitorTemplate<DaypartInfo, DayparchInfo> {

	@Override public boolean shouldMerge(DaypartInfo baseInfo, DayparchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<DaypartInfo> merge(DaypartInfo baseInfo, DayparchInfo selectedInfo) {
		List<DaypartInfo> results = new ArrayList<>();
		
		DaypartInfo result = DaypartInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
