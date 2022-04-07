package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatsnapMergerVisiMatoup extends InfoMergerVisitorTemplate<MatsnapInfo, MatoupInfo> {

	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codGroup == selectedInfo.codGroup);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatoupInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtGroup = selectedInfo.txtGroup;
		baseInfo.codBusiness = selectedInfo.codBusiness;
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
