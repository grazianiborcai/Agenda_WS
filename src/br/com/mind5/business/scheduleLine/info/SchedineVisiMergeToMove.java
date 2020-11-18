package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeToMove extends InfoMergerVisitorTemplate<SchedineInfo, SchedineInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, SchedineInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner &&
				baseInfo.codSchedule == selectedInfo.codSchedule);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, SchedineInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codOrder = selectedInfo.codOrder;
		baseInfo.codOrderItem = selectedInfo.codOrderItem;
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		baseInfo.codScheduleStatusOld = selectedInfo.codScheduleStatusOld;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
