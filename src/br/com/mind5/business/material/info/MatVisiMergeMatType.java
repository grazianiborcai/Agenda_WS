package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatVisiMergeMatType implements InfoMergerVisitorV3<MatInfo, MatTypeInfo> {
	
	@Override public List<MatInfo> beforeMerge(List<MatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatInfo baseInfo, MatTypeInfo selectedInfo) {
		return (baseInfo.codType == selectedInfo.codType);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatTypeInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtType = selectedInfo.txtType;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatInfo> getUniquifier() {
		return null;
	}
}
