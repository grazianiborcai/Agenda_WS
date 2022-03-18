package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatMergerVisiMatoup extends InfoMergerVisitorTemplate<MatInfo, MatoupInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatoupInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtGroup = selectedInfo.txtGroup;
		baseInfo.codBusiness = selectedInfo.codBusiness;
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
