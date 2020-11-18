package br.com.mind5.business.addressSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.country.info.CountryInfo;

final class AddresnapVisiMergeCountry extends InfoMergerVisitorTemplate<AddresnapInfo, CountryInfo> {
	
	@Override public List<AddresnapInfo> beforeMerge(List<AddresnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddresnapInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<AddresnapInfo> merge(AddresnapInfo baseInfo, CountryInfo selectedInfo) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.codCountryAlpha3 = selectedInfo.codCountryAlpha3;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddresnapInfo> getUniquifier() {
		return null;
	}
}
