package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class AddresnapMergerEmplis extends InfoMergerTemplate<AddresnapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, EmplisInfo> getVisitorHook() {
		return new AddresnapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
