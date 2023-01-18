package br.com.mind5.masterData.bankSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.country.info.CountryInfo;

final class BankarchMergerVisiCountry extends InfoMergerVisitorTemplate<BankarchInfo, CountryInfo> {

	@Override public boolean shouldMerge(BankarchInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<BankarchInfo> merge(BankarchInfo baseInfo, CountryInfo selectedInfo) {
		List<BankarchInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		
		results.add(baseInfo);
		return results;
	}
}
