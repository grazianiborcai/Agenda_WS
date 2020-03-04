package br.com.mind5.business.addressSearch.info;


import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class AddarchCopier {	
	public static AddarchInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<AddarchInfo, StoreInfo> copier = new AddarchCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<AddarchInfo, StoreInfo> copier = new AddarchCopyStoreKey();
		return copier.makeCopy(sources);
	}
	
	
	
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
	
	
	
	public static AddarchInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<AddarchInfo, CusparInfo> copier = new AddarchCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddarchInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<AddarchInfo, CusparInfo> copier = new AddarchCopyCuspar();
		return copier.makeCopy(sources);
	}	
}
