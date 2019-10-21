package br.com.mind5.business.employee.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerAddress extends InfoMergerTemplate<EmpInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, AddressInfo> getVisitorHook() {
		return new EmpVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
