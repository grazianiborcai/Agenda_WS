package br.com.gda.business.person.info;


import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoCopier;

public final class PersonCopier {
	public static PersonInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<PersonInfo, OwnerInfo> copier = new PersonCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<PersonInfo, OwnerInfo> copier = new PersonCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonInfo copyFromStore(StoreInfo source) {
		InfoCopier<PersonInfo, StoreInfo> copier = new PersonCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<PersonInfo, StoreInfo> copier = new PersonCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonInfo copyFromEmp(EmpInfo source) {
		InfoCopier<PersonInfo, EmpInfo> copier = new PersonCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<PersonInfo, EmpInfo> copier = new PersonCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonInfo copyFromUser(UserInfo source) {
		InfoCopier<PersonInfo, UserInfo> copier = new PersonCopyUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromUser(List<UserInfo> sources) {
		InfoCopier<PersonInfo, UserInfo> copier = new PersonCopyUser();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonInfo copyFromCus(CusInfo source) {
		InfoCopier<PersonInfo, CusInfo> copier = new PersonCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<PersonInfo, CusInfo> copier = new PersonCopyCus();
		return copier.makeCopy(sources);
	}
}
