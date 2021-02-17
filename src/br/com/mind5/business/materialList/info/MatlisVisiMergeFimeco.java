package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatlisVisiMergeFimeco extends InfoMergerVisitorTemplate<MatlisInfo, FimecoInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, FimecoInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codMat 	== selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, FimecoInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.fimecoData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
