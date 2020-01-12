package br.com.mind5.business.phoneSearch.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoCopier;

public final class PhonarchCopier {	
	public static PhonarchInfo copyFromPhoneRef(PhoneInfo source) {
		InfoCopier<PhonarchInfo, PhoneInfo> copier = new PhonarchCopyPhoneRef();
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
}
