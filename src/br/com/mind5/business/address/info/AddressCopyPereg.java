package br.com.mind5.business.address.info;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class AddressCopyPereg extends InfoCopierTemplate<AddressInfo, PeregInfo> {
	
	public AddressCopyPereg() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(PeregInfo source) {
		return source.addressData;
	}
}
