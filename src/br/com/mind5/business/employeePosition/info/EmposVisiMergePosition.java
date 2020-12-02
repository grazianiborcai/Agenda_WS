package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.position.info.PositionInfo;

final class EmposVisiMergePosition extends InfoMergerVisitorTemplate<EmposInfo, PositionInfo> {
	@Override public boolean shouldMerge(EmposInfo baseInfo, PositionInfo selectedInfo) {
		return (baseInfo.codPosition == selectedInfo.codPosition);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, PositionInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.txtPosition = selectedInfo.txtPosition;
		
		results.add(baseInfo);
		return results;
	}
}
