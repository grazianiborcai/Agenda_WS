package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerAddress extends InfoMergerTemplate<EmpnapInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, AddressInfo> getVisitorHook() {
		return new EmpnapVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
