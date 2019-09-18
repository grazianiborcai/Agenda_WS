package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class AddresnapMergerEmplis extends InfoMergerTemplate<AddresnapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor<AddresnapInfo, EmplisInfo> getVisitorHook() {
		return new AddresnapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
