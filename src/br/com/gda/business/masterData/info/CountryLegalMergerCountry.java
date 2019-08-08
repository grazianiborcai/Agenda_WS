package br.com.gda.business.masterData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CountryLegalMergerCountry extends InfoMergerTemplate<CountryLegalInfo, CountryInfo> {

	@Override protected InfoMergerVisitor<CountryLegalInfo, CountryInfo> getVisitorHook() {
		return new CountryLegalVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<CountryLegalInfo> getUniquifierHook() {
		return new CountryLegalUniquifier();
	}
}
