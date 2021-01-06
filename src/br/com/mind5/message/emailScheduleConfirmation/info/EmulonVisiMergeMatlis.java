package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmulonVisiMergeMatlis extends InfoMergerVisitorTemplate<EmulonInfo, MatlisInfo> {

	@Override public boolean shouldMerge(EmulonInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner ||
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<EmulonInfo> merge(EmulonInfo baseInfo, MatlisInfo selectedInfo) {
		List<EmulonInfo> results = new ArrayList<>();
		
		baseInfo.txtMat = selectedInfo.txtMat;
		
		results.add(baseInfo);
		return results;
	}
}
