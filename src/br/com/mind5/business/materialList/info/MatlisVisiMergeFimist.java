package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatlisVisiMergeFimist extends InfoMergerVisitorTemplate<MatlisInfo, FimistInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codMat 	== selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, FimistInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.fimistes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
