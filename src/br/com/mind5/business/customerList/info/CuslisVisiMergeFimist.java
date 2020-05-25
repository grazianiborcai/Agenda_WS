package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CuslisVisiMergeFimist implements InfoMergerVisitorV3<CuslisInfo, FimistInfo> {
	
	@Override public List<CuslisInfo> beforeMerge(List<CuslisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CuslisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CuslisInfo> merge(CuslisInfo baseInfo, FimistInfo selectedInfo) {
		List<CuslisInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CuslisInfo> getUniquifier() {
		return null;
	}
}
