package br.com.mind5.business.employee.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerAddress extends InfoMergerTemplate_<EmpInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, AddressInfo> getVisitorHook() {
		return new EmpVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
