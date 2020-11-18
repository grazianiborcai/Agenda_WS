package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

final class MatlisVisiMergeMatunit extends InfoMergerVisitorTemplate<MatlisInfo, MatunitInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatunitInfo selectedInfo) {
		return (baseInfo.codUnit.equals(selectedInfo.codUnit));
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatunitInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtUnit = selectedInfo.txtUnit;
		
		results.add(baseInfo);
		return results;
	}
}
