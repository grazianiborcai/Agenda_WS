package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapMergerVisiPhonaparch extends InfoMergerVisitorTemplate<PhonapInfo, PhonaparchInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, PhonaparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, PhonaparchInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		PhonapInfo result = PhonapInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
