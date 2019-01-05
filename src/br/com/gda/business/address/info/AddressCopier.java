package br.com.gda.business.address.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class AddressCopier {
	public static AddressInfo copyFromPayCusRef(PayCusInfo source) {
		InfoCopier<AddressInfo, PayCusInfo> copier = new AddressCopyPayCusRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromPayCusRef(List<PayCusInfo> sources) {
		InfoCopier<AddressInfo, PayCusInfo> copier = new AddressCopyPayCusRef();
		return copier.makeCopy(sources);
	}
}
