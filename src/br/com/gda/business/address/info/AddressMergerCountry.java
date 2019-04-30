package br.com.gda.business.address.info;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerCountry extends InfoMergerTemplate<AddressInfo, CountryInfo> {

	@Override protected InfoMergerVisitorV2<AddressInfo, CountryInfo> getVisitorHook() {
		return new AddressVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
