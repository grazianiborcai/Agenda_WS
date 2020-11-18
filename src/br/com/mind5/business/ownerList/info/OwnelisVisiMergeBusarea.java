package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

final class OwnelisVisiMergeBusarea extends InfoMergerVisitorTemplate<OwnelisInfo, BusareaInfo> {
	
	@Override public List<OwnelisInfo> beforeMerge(List<OwnelisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnelisInfo baseInfo, BusareaInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, BusareaInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnelisInfo> getUniquifier() {
		return null;
	}
}
