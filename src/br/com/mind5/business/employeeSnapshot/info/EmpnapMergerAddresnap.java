package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapMergerAddresnap extends InfoMergerTemplate<EmpnapInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, AddresnapInfo> getVisitorHook() {
		return new EmpnapVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
