package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

final class MatVisiMergeMatype extends InfoMergerVisitorTemplate<MatInfo, MatypeInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatypeInfo selectedInfo) {
		return (baseInfo.codType == selectedInfo.codType);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatypeInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtType = selectedInfo.txtType;
		
		results.add(baseInfo);
		return results;
	}
}
