package br.com.mind5.business.masterData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CountryLegalMergerCountry extends InfoMergerTemplate_<CountryLegalInfo, CountryInfo> {

	@Override protected InfoMergerVisitor_<CountryLegalInfo, CountryInfo> getVisitorHook() {
		return new CountryLegalVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<CountryLegalInfo> getUniquifierHook() {
		return new CountryLegalUniquifier();
	}
}
