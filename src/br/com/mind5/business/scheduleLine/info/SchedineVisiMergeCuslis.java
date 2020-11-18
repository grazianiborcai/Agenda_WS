package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeCuslis extends InfoMergerVisitorTemplate<SchedineInfo, CuslisInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	 && 
				baseInfo.codCustomer == selectedInfo.codCustomer		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, CuslisInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
