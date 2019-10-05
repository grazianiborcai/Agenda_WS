package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class PhoneCopier {
	public static List<PhoneInfo> copyFromStore(StoreInfo source) {
		InfoCopierOneToMany<PhoneInfo, StoreInfo> copier = new PhoneCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopierOneToMany<PhoneInfo, StoreInfo> copier = new PhoneCopyStore();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static PhoneInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<PhoneInfo, CrecardInfo> copier = new PhoneCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<PhoneInfo, CrecardInfo> copier = new PhoneCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhoneInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<PhoneInfo, CusparInfo> copier = new PhoneCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<PhoneInfo, CusparInfo> copier = new PhoneCopyCuspar();
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
	
	
	
	public static PhoneInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<PhoneInfo, StoreInfo> copier = new PhoneCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<PhoneInfo, StoreInfo> copier = new PhoneCopyStoreKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhoneInfo copyFromStolis(StolisInfo source) {
		InfoCopier<PhoneInfo, StolisInfo> copier = new PhoneCopyStolis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromStolis(List<StolisInfo> sources) {
		InfoCopier<PhoneInfo, StolisInfo> copier = new PhoneCopyStolis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<PhoneInfo> copyFromEmp(EmpInfo source) {
		InfoCopierOneToMany<PhoneInfo, EmpInfo> copier = new PhoneCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopierOneToMany<PhoneInfo, EmpInfo> copier = new PhoneCopyEmp();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static PhoneInfo copyFromEmpKey(EmpInfo source) {
		InfoCopier<PhoneInfo, EmpInfo> copier = new PhoneCopyEmpKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromEmpKey(List<EmpInfo> sources) {
		InfoCopier<PhoneInfo, EmpInfo> copier = new PhoneCopyEmpKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhoneInfo copyFromCus(CusInfo source) {
		InfoCopier<PhoneInfo, CusInfo> copier = new PhoneCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhoneInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<PhoneInfo, CusInfo> copier = new PhoneCopyCus();
		return copier.makeCopy(sources);
	}
}
