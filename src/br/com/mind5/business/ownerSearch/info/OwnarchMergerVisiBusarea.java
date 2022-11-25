package br.com.mind5.business.ownerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

final class OwnarchMergerVisiBusarea extends InfoMergerVisitorTemplate<OwnarchInfo, BusareaInfo> {
	
	@Override public boolean shouldMerge(OwnarchInfo baseInfo, BusareaInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<OwnarchInfo> merge(OwnarchInfo baseInfo, BusareaInfo selectedInfo) {
		List<OwnarchInfo> results = new ArrayList<>();
		
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
