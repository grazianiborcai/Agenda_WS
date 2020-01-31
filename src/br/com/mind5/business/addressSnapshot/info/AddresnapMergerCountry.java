package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapMergerCountry extends InfoMergerTemplate_<AddresnapInfo, CountryInfo> {

	@Override protected InfoMergerVisitor_<AddresnapInfo, CountryInfo> getVisitorHook() {
		return new AddresnapVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
