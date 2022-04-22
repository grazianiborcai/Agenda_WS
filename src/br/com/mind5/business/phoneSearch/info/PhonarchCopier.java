package br.com.mind5.business.phoneSearch.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class PhonarchCopier {	
	public static PhonarchInfo copyFromStore(StoreInfo source) {
		InfoCopier<PhonarchInfo, StoreInfo> copier = new PhonarchCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonarchInfo> copyFromPhoneRef(List<PhoneInfo> sources) {
		InfoCopier<PhonarchInfo, PhoneInfo> copier = new PhonarchCopyPhoneRef();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonarchInfo copyFromCusKey(CusInfo source) {
		InfoCopier<PhonarchInfo, CusInfo> copier = new PhonarchCopyCusKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonarchInfo> copyFromCusKey(List<CusInfo> sources) {
		InfoCopier<PhonarchInfo, CusInfo> copier = new PhonarchCopyCusKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonarchInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<PhonarchInfo, CrecardInfo> copier = new PhonarchCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonarchInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<PhonarchInfo, CrecardInfo> copier = new PhonarchCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonarchInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<PhonarchInfo, CusparInfo> copier = new PhonarchCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonarchInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<PhonarchInfo, CusparInfo> copier = new PhonarchCopyCuspar();
		return copier.makeCopy(sources);
	}
}
