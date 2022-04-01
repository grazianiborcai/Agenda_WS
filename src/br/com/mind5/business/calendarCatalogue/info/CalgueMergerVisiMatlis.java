package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalgueMergerVisiMatlis extends InfoMergerVisitorTemplate<CalgueInfo, MatlisInfo> {

	@Override public boolean shouldMerge(CalgueInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
			    baseInfo.codMat   == selectedInfo.codMat);
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, MatlisInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
