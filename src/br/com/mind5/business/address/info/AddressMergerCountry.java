package br.com.mind5.business.address.info;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerCountry extends InfoMergerTemplate<AddressInfo, CountryInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, CountryInfo> getVisitorHook() {
		return new AddressVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
