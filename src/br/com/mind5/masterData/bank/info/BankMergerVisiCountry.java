package br.com.mind5.masterData.bank.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.country.info.CountryInfo;

final class BankMergerVisiCountry extends InfoMergerVisitorTemplate<BankInfo, CountryInfo> {

	@Override public boolean shouldMerge(BankInfo baseInfo, CountryInfo selectedInfo) {
		return baseInfo.codCountry.equals(selectedInfo.codCountry);
	}
	
	
	
	@Override public List<BankInfo> merge(BankInfo baseInfo, CountryInfo selectedInfo) {
		List<BankInfo> results = new ArrayList<>();
		BankInfo result = new BankInfo();
		
		result = BankInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
