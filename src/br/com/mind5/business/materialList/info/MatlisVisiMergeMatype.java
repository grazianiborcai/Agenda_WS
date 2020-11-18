package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

final class MatlisVisiMergeMatype extends InfoMergerVisitorTemplate<MatlisInfo, MatypeInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatypeInfo selectedInfo) {
		return (baseInfo.codType == selectedInfo.codType);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatypeInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.txtType = selectedInfo.txtType;
		
		results.add(baseInfo);
		return results;
	}
}
