package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PhoneCopier {
	public static PhoneInfo copyFromPayCusRef(PaycusInfo source) {
		InfoCopier<PhoneInfo, PaycusInfo> copier = new PhoneCopyPayCusRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromPayCusRef(List<PaycusInfo> sources) {
		InfoCopier<PhoneInfo, PaycusInfo> copier = new PhoneCopyPayCusRef();
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
	
	
	
	public static PhoneInfo copyFromStore(StoreInfo source) {
		InfoCopier<PhoneInfo, StoreInfo> copier = new PhoneCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<PhoneInfo, StoreInfo> copier = new PhoneCopyStore();
		return copier.makeCopy(sources);
	}
}
