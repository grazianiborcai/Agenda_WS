package br.com.mind5.business.address.info;


import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.security.user.info.UserInfo;

public final class AddressCopier {
	public static List<AddressInfo> copyFromStore(StoreInfo source) {
		InfoCopierOneToMany<AddressInfo, StoreInfo> copier = new AddressCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopierOneToMany<AddressInfo, StoreInfo> copier = new AddressCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<AddressInfo, CrecardInfo> copier = new AddressCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<AddressInfo, CrecardInfo> copier = new AddressCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<AddressInfo, CusparInfo> copier = new AddressCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<AddressInfo, CusparInfo> copier = new AddressCopyCuspar();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<AddressInfo> copyFromOwner(OwnerInfo source) {
		InfoCopierOneToMany<AddressInfo, OwnerInfo> copier = new AddressCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopierOneToMany<AddressInfo, OwnerInfo> copier = new AddressCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromOwnerKey(OwnerInfo source) {
		InfoCopier<AddressInfo, OwnerInfo> copier = new AddressCopyOwnerKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromOwnerKey(List<OwnerInfo> sources) {
		InfoCopier<AddressInfo, OwnerInfo> copier = new AddressCopyOwnerKey();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static AddressInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<AddressInfo, StoreInfo> copier = new AddressCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<AddressInfo, StoreInfo> copier = new AddressCopyStoreKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<AddressInfo> copyFromEmp(EmpInfo source) {
		InfoCopierOneToMany<AddressInfo, EmpInfo> copier = new AddressCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopierOneToMany<AddressInfo, EmpInfo> copier = new AddressCopyEmp();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static AddressInfo copyFromEmpKey(EmpInfo source) {
		InfoCopier<AddressInfo, EmpInfo> copier = new AddressCopyEmpKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromEmpKey(List<EmpInfo> sources) {
		InfoCopier<AddressInfo, EmpInfo> copier = new AddressCopyEmpKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromStolis(StolisInfo source) {
		InfoCopier<AddressInfo, StolisInfo> copier = new AddressCopyStolis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromStolis(List<StolisInfo> sources) {
		InfoCopier<AddressInfo, StolisInfo> copier = new AddressCopyStolis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromUserKey(UserInfo source) {
		InfoCopier<AddressInfo, UserInfo> copier = new AddressCopyUserKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromUserKey(List<UserInfo> sources) {
		InfoCopier<AddressInfo, UserInfo> copier = new AddressCopyUserKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromCus(CusInfo source) {
		InfoCopier<AddressInfo, CusInfo> copier = new AddressCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<AddressInfo, CusInfo> copier = new AddressCopyCus();
		return copier.makeCopy(sources);
	}
}
