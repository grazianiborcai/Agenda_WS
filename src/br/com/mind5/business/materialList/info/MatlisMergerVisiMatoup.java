package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatlisMergerVisiMatoup extends InfoMergerVisitorTemplate<MatlisInfo, MatoupInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatoupInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtGroup = selectedInfo.txtGroup;
		baseInfo.codBusiness = selectedInfo.codBusiness;
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
