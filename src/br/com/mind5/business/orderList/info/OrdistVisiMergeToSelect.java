package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdistVisiMergeToSelect extends InfoMergerVisitorTemplate<OrdistInfo, OrdistInfo> {

	@Override public boolean shouldMerge(OrdistInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, OrdistInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override protected List<OrdistInfo> afterMergeHook(List<OrdistInfo> results)  {
		return super.sortDescending(results);
	}
}
