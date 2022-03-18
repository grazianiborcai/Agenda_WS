package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatMergerVisiFimeco extends InfoMergerVisitorTemplate<MatInfo, FimecoInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, FimecoInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codMat 	== selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, FimecoInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.fimecoData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
