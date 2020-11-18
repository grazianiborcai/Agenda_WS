package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmulelVisiMergeCuslis extends InfoMergerVisitorTemplate<EmulelInfo, CuslisInfo> {
	
	@Override public List<EmulelInfo> beforeMerge(List<EmulelInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmulelInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 	||
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<EmulelInfo> merge(EmulelInfo baseInfo, CuslisInfo selectedInfo) {
		List<EmulelInfo> results = new ArrayList<>();
		
		baseInfo.cuslisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmulelInfo> getUniquifier() {
		return null;
	}
}
