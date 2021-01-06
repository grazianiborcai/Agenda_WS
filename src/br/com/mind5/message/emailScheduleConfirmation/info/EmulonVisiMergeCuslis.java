package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmulonVisiMergeCuslis extends InfoMergerVisitorTemplate<EmulonInfo, CuslisInfo> {

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
}
