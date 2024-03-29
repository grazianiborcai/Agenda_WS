package br.com.mind5.business.materialGroupStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoporeMergerVisiMatore extends InfoMergerVisitorTemplate<MatoporeInfo, MatoreInfo> {

	@Override public boolean shouldMerge(MatoporeInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore	&&
				selectedInfo.matlisData != null);
	}
	
	
	
	@Override public List<MatoporeInfo> merge(MatoporeInfo baseInfo, MatoreInfo selectedInfo) {
		List<MatoporeInfo> results = new ArrayList<>();
		
		baseInfo.codGroup = selectedInfo.matlisData.codGroup;
		baseInfo.txtGroup = selectedInfo.matlisData.txtGroup;
		
		results.add(baseInfo);
		return results;
	}
}
