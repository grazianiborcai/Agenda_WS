package br.com.mind5.business.address.info;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class AddressCopyOwner extends InfoCopierOneToManyTemplate<AddressInfo, OwnerInfo>{
	
	public AddressCopyOwner() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(OwnerInfo source) {
		return source.addresses;
	}
}
