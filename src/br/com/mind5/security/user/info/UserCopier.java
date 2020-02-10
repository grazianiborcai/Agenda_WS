package br.com.mind5.security.user.info;


import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class UserCopier {	
	public static UserInfo copyFromUauth(UauthInfo source) {
		InfoCopier<UserInfo, UauthInfo> copier = new UserCopyUauth();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromUauth(List<UauthInfo> sources) {
		InfoCopier<UserInfo, UauthInfo> copier = new UserCopyUauth();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromOwnerKey(OwnerInfo source) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwnerKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromOwnerKey(List<OwnerInfo> sources) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwnerKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromStorap(StorapInfo source) {
		InfoCopier<UserInfo, StorapInfo> copier = new UserCopyStorap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromStorap(List<StorapInfo> sources) {
		InfoCopier<UserInfo, StorapInfo> copier = new UserCopyStorap();
		return copier.makeCopy(sources);
	}
	
	

	public static UserInfo copyFromStore(StoreInfo source) {
		InfoCopier<UserInfo, StoreInfo> copier = new UserCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<UserInfo, StoreInfo> copier = new UserCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromStoreKey(StoreInfo source) {
		InfoCopier<UserInfo, StoreInfo> copier = new UserCopyStoreKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromStoreKey(List<StoreInfo> sources) {
		InfoCopier<UserInfo, StoreInfo> copier = new UserCopyStoreKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromEmp(EmpInfo source) {
		InfoCopier<UserInfo, EmpInfo> copier = new UserCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromEmpKey(List<EmpInfo> sources) {
		InfoCopier<UserInfo, EmpInfo> copier = new UserCopyEmpKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromEmpKey(EmpInfo source) {
		InfoCopier<UserInfo, EmpInfo> copier = new UserCopyEmpKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<UserInfo, EmpInfo> copier = new UserCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyToDelete(UserInfo source) {
		InfoCopier<UserInfo, UserInfo> copier = new UserCopyToDelete();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyToDelete(List<UserInfo> sources) {
		InfoCopier<UserInfo, UserInfo> copier = new UserCopyToDelete();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromCusKey(CusInfo source) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCusKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromCusKey(List<CusInfo> sources) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCusKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromCusDaemon(CusInfo source) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCusDaemon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromCusDaemon(List<CusInfo> sources) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCusDaemon();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UserInfo copyFromCus(CusInfo source) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<UserInfo, CusInfo> copier = new UserCopyCus();
		return copier.makeCopy(sources);
	}
}
