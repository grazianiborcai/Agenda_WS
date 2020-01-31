package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpnapMergerAddresnap extends InfoMergerTemplate_<EmpnapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, AddresnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
