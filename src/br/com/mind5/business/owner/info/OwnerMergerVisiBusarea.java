package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

final class OwnerMergerVisiBusarea extends InfoMergerVisitorTemplate<OwnerInfo, BusareaInfo> {

	@Override public boolean shouldMerge(OwnerInfo baseInfo, BusareaInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, BusareaInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<OwnerInfo> uniquifyHook(List<OwnerInfo> results) {
		InfoUniquifier<OwnerInfo> uniquifier = new OwnerUniquifier();		
		return uniquifier.uniquify(results);
	}
}
