package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

final class PhoneVisiMergeCountrone implements InfoMergerVisitorV3<PhoneInfo, CountroneInfo> {
	
	@Override public List<PhoneInfo> beforeMerge(List<PhoneInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PhoneInfo baseInfo, CountroneInfo selectedInfo) {
		return (baseInfo.codCountryPhone == selectedInfo.codCountryPhone);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, CountroneInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PhoneInfo> getUniquifier() {
		return null;
	}
}
