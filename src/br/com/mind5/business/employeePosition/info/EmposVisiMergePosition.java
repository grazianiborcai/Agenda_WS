package br.com.mind5.business.employeePosition.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmposVisiMergePosition implements InfoMergerVisitorV3<EmposInfo, PositionInfo> {
	
	@Override public List<EmposInfo> beforeMerge(List<EmposInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmposInfo baseInfo, PositionInfo selectedInfo) {
		return (baseInfo.codPosition == selectedInfo.codPosition);
	}
	
	
	
	@Override public List<EmposInfo> merge(EmposInfo baseInfo, PositionInfo selectedInfo) {
		List<EmposInfo> results = new ArrayList<>();
		
		baseInfo.txtPosition = selectedInfo.txtPosition;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmposInfo> getUniquifier() {
		return null;
	}
}
