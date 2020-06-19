package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmulonVisiMergeCuslis implements InfoMergerVisitorV3<EmulonInfo, CuslisInfo> {
	
	@Override public List<EmulonInfo> beforeMerge(List<EmulonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulonInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	||
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<EmulonInfo> merge(EmulonInfo baseInfo, CuslisInfo selectedInfo) {
		List<EmulonInfo> results = new ArrayList<>();
		
		baseInfo.cuslisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulonInfo> getUniquifier() {
		return null;
	}
}
