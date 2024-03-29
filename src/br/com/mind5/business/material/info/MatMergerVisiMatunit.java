package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

final class MatMergerVisiMatunit extends InfoMergerVisitorTemplate<MatInfo, MatunitInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatunitInfo selectedInfo) {
		return (baseInfo.codUnit.equals(selectedInfo.codUnit));
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatunitInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtUnit = selectedInfo.txtUnit;
		
		results.add(baseInfo);
		return results;
	}
}
