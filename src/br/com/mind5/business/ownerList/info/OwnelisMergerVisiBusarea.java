package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

final class OwnelisMergerVisiBusarea extends InfoMergerVisitorTemplate<OwnelisInfo, BusareaInfo> {
	
	@Override public boolean shouldMerge(OwnelisInfo baseInfo, BusareaInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, BusareaInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
