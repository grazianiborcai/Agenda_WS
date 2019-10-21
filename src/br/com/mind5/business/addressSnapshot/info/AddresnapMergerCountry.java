package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddresnapMergerCountry extends InfoMergerTemplate<AddresnapInfo, CountryInfo> {

	@Override protected InfoMergerVisitor<AddresnapInfo, CountryInfo> getVisitorHook() {
		return new AddresnapVisiMergeCountry();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
