package br.com.mind5.business.address.info;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerCountry extends InfoMergerTemplate_<AddressInfo, CountryInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, CountryInfo> getVisitorHook() {
		return new AddressVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
