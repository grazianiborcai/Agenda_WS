package br.com.gda.business.addressSnapshot.info;


import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.info.InfoCopier;
import br.com.gda.info.InfoCopierOneToMany;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class AddresnapCopier {	
	public static AddresnapInfo copyFromStorap(StorapInfo source) {
		InfoCopier<AddresnapInfo, StorapInfo> copier = new AddresnapCopyStorap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddresnapInfo> copyFromStorap(List<StorapInfo> sources) {
		InfoCopier<AddresnapInfo, StorapInfo> copier = new AddresnapCopyStorap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static AddresnapInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<AddresnapInfo, CusparInfo> copier = new AddresnapCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddresnapInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<AddresnapInfo, CusparInfo> copier = new AddresnapCopyCuspar();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<AddresnapInfo> copyFromEmpnap(EmpnapInfo source) {
		InfoCopierOneToMany<AddresnapInfo, EmpnapInfo> copier = new AddresnapCopyEmpnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddresnapInfo> copyFromEmpnap(List<EmpnapInfo> sources) {
		InfoCopierOneToMany<AddresnapInfo, EmpnapInfo> copier = new AddresnapCopyEmpnap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static AddresnapInfo copyFromEmpnapKey(EmpnapInfo source) {
		InfoCopier<AddresnapInfo, EmpnapInfo> copier = new AddresnapCopyEmpnapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddresnapInfo> copyFromEmpnapKey(List<EmpnapInfo> sources) {
		InfoCopier<AddresnapInfo, EmpnapInfo> copier = new AddresnapCopyEmpnapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static AddresnapInfo copyFromUserapKey(UserapInfo source) {
		InfoCopier<AddresnapInfo, UserapInfo> copier = new AddresnapCopyUserapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<AddresnapInfo> copyFromUserapKey(List<UserapInfo> sources) {
		InfoCopier<AddresnapInfo, UserapInfo> copier = new AddresnapCopyUserapKey();
		return copier.makeCopy(sources);
	}	
}
