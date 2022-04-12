package br.com.mind5.business.storeLeaveDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StolateMergerVisiStolis extends InfoMergerVisitorTemplate<StolateInfo, StolisInfo> {

	@Override public boolean shouldMerge(StolateInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolateInfo> merge(StolateInfo baseInfo, StolisInfo selectedInfo) {
		List<StolateInfo> results = new ArrayList<>();
		
		baseInfo.codTimezone = selectedInfo.codTimezone;
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
}
