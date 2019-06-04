package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerAddresnap extends InfoMergerTemplate<EmpnapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, AddresnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
