package br.com.mind5.business.masterData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CountryLegalMergerCountry extends InfoMergerTemplate<CountryLegalInfo, CountryInfo> {

	@Override protected InfoMergerVisitor<CountryLegalInfo, CountryInfo> getVisitorHook() {
		return new CountryLegalVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<CountryLegalInfo> getUniquifierHook() {
		return new CountryLegalUniquifier();
	}
}
