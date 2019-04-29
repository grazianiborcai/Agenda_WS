package br.com.gda.business.employee.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerAddress extends InfoMergerTemplate<EmpInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<EmpInfo, AddressInfo> getVisitorHook() {
		return new EmpVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
