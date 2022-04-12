package br.com.mind5.business.phoneSnapshotSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonaparchMergerVisiToSelect extends InfoMergerVisitorTemplate<PhonaparchInfo, PhonaparchInfo> {

	@Override public boolean shouldMerge(PhonaparchInfo baseInfo, PhonaparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhonaparchInfo> merge(PhonaparchInfo baseInfo, PhonaparchInfo selectedInfo) {
		List<PhonaparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
