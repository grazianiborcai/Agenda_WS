package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

final class MatsnapMergerVisiMatunit extends InfoMergerVisitorTemplate<MatsnapInfo, MatunitInfo> {

	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatunitInfo selectedInfo) {
		return (baseInfo.codUnit.equals(selectedInfo.codUnit));
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatunitInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtUnit = selectedInfo.txtUnit;
		
		results.add(baseInfo);
		return results;
	}
}
