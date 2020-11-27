package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CuslisVisiMergeFimist extends InfoMergerVisitorTemplate<CuslisInfo, FimistInfo> {

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
}
