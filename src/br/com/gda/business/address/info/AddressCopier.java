package br.com.gda.business.address.info;


import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class AddressCopier {
	public static AddressInfo copyFromPayCusRef(PaycusInfo source) {
		InfoCopier<AddressInfo, PaycusInfo> copier = new AddressCopyPayCusRef();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromPayCusRef(List<PaycusInfo> sources) {
		InfoCopier<AddressInfo, PaycusInfo> copier = new AddressCopyPayCusRef();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<AddressInfo, OwnerInfo> copier = new AddressCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<AddressInfo, OwnerInfo> copier = new AddressCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddressInfo copyFromStore(StoreInfo source) {
		InfoCopier<AddressInfo, StoreInfo> copier = new AddressCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddressInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<AddressInfo, StoreInfo> copier = new AddressCopyStore();
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
