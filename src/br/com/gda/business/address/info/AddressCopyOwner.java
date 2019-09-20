package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class AddressCopyOwner extends InfoCopierOneToManyTemplate<AddressInfo, OwnerInfo>{
	
	public AddressCopyOwner() {
		super();
	}
	
	
	
	@Override protected List<AddressInfo> makeCopyHook(OwnerInfo source) {
		return source.addresses;
	}
}
