package br.com.gda.business.addressSearch.info;


import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoCopier;

public final class AddarchCopier {
	public static AddarchInfo copyFromAddressRef(AddressInfo source) {
		InfoCopier<AddarchInfo, AddressInfo> copier = new AddarchCopyAddressRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromAddressRef(List<AddressInfo> sources) {
		InfoCopier<AddarchInfo, AddressInfo> copier = new AddarchCopyAddressRef();
		return copier.makeCopy(sources);
	}
}
