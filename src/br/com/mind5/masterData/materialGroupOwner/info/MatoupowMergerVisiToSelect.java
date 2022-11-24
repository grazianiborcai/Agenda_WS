package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoupowMergerVisiToSelect extends InfoMergerVisitorTemplate<MatoupowInfo, MatoupowInfo> {

	@Override public boolean shouldMerge(MatoupowInfo baseInfo, MatoupowInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatoupowInfo> merge(MatoupowInfo baseInfo, MatoupowInfo selectedInfo) {
		List<MatoupowInfo> results = new ArrayList<>();		
		
		baseInfo.isLocked 		= selectedInfo.isLocked;
		baseInfo.rgbHex 		= selectedInfo.rgbHex;
		baseInfo.rgbDecRed 		= selectedInfo.rgbDecRed;
		baseInfo.rgbDecGreen 	= selectedInfo.rgbDecGreen;
		baseInfo.rgbDecBlue 	= selectedInfo.rgbDecBlue;
		baseInfo.recordMode 	= selectedInfo.recordMode;
		baseInfo.lastChanged 	= selectedInfo.lastChanged;
		baseInfo.lastChangedBy 	= selectedInfo.lastChangedBy;
		baseInfo.createdOn 		= selectedInfo.createdOn;
		baseInfo.createdBy 		= selectedInfo.createdBy;		
		
		results.add(baseInfo);
		return results;
	}
}
