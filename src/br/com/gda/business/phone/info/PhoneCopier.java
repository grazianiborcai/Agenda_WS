package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PhoneCopier {
	public static PhoneInfo copyFromPayCusRef(PayCusInfo source) {
		InfoCopier<PhoneInfo, PayCusInfo> copier = new PhoneCopyPayCusRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromPayCusRef(List<PayCusInfo> sources) {
		InfoCopier<PhoneInfo, PayCusInfo> copier = new PhoneCopyPayCusRef();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhoneInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<PhoneInfo, OwnerInfo> copier = new PhoneCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<PhoneInfo, OwnerInfo> copier = new PhoneCopyOwner();
		return copier.makeCopy(sources);
	}
}
