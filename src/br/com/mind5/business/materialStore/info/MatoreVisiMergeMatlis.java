package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreVisiMergeMatlis extends InfoMergerVisitorTemplate<MatoreInfo, MatlisInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatlisInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
