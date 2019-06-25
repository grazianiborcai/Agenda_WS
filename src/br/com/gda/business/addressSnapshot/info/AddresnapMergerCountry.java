package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddresnapMergerCountry extends InfoMergerTemplate<AddresnapInfo, CountryInfo> {

	@Override protected InfoMergerVisitorV2<AddresnapInfo, CountryInfo> getVisitorHook() {
		return new AddresnapVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
