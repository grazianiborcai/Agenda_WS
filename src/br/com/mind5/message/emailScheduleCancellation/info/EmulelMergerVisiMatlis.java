package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmulelMergerVisiMatlis extends InfoMergerVisitorTemplate<EmulelInfo, MatlisInfo> {

	@Override public boolean shouldMerge(EmulelInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner ||
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<EmulelInfo> merge(EmulelInfo baseInfo, MatlisInfo selectedInfo) {
		List<EmulelInfo> results = new ArrayList<>();
		
		baseInfo.txtMat = selectedInfo.txtMat;
		
		results.add(baseInfo);
		return results;
	}
}
