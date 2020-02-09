package br.com.mind5.business.addressSearch.info;


import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class AddarchCopier {	
	public static AddarchInfo copyFromAdddressRef(AddressInfo source) {
		InfoCopier<AddarchInfo, AddressInfo> copier = new AddarchCopyAddressRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromAdddressRef(List<AddressInfo> sources) {
		InfoCopier<AddarchInfo, AddressInfo> copier = new AddarchCopyAddressRef();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddarchInfo copyFromCusKey(CusInfo source) {
		InfoCopier<AddarchInfo, CusInfo> copier = new AddarchCopyCusKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromCusKey(List<CusInfo> sources) {
		InfoCopier<AddarchInfo, CusInfo> copier = new AddarchCopyCusKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddarchInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<AddarchInfo, CrecardInfo> copier = new AddarchCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<AddarchInfo, CrecardInfo> copier = new AddarchCopyCrecard();
		return copier.makeCopy(sources);
	}
}
