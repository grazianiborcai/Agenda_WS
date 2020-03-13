package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatVisiMergeMatUnit implements InfoMergerVisitorV3<MatInfo, MatUnitInfo> {
	
	@Override public List<MatInfo> beforeMerge(List<MatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatInfo baseInfo, MatUnitInfo selectedInfo) {
		return (baseInfo.codUnit.equals(selectedInfo.codUnit));
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatUnitInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtUnit = selectedInfo.txtUnit;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatInfo> getUniquifier() {
		return null;
	}
}
