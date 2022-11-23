package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatoupowMergerVisiMatoup extends InfoMergerVisitorTemplate<MatoupowInfo, MatoupInfo> {

	@Override public boolean shouldMerge(MatoupowInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<MatoupowInfo> merge(MatoupowInfo baseInfo, MatoupInfo selectedInfo) {
		List<MatoupowInfo> results = new ArrayList<>();
		
		baseInfo.codGroup = selectedInfo.codGroup;
		baseInfo.txtGroup = selectedInfo.txtGroup;
		baseInfo.codBusiness = selectedInfo.codBusiness;
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		baseInfo.fimgysData = selectedInfo.fimgysData;
		
		results.add(baseInfo);
		return results;
	}
}
