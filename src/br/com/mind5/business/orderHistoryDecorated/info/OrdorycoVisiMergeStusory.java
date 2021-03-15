package br.com.mind5.business.orderHistoryDecorated.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;

final class OrdorycoVisiMergeStusory extends InfoMergerVisitorTemplate<OrdorycoInfo, StusoryInfo> {

	@Override public boolean shouldMerge(OrdorycoInfo baseInfo, StusoryInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	

	@Override public List<OrdorycoInfo> merge(OrdorycoInfo baseInfo, StusoryInfo selectedInfo) {
		List<OrdorycoInfo> results = new ArrayList<>();
		
		baseInfo.stusorys.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
