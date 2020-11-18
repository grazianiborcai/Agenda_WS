package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

final class PhonapVisiMergeCountrone extends InfoMergerVisitorTemplate<PhonapInfo, CountroneInfo> {
	
	@Override public List<PhonapInfo> beforeMerge(List<PhonapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhonapInfo baseInfo, CountroneInfo selectedInfo) {
		return (baseInfo.codCountryPhone == selectedInfo.codCountryPhone);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, CountroneInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhonapInfo> getUniquifier() {
		return null;
	}
}
