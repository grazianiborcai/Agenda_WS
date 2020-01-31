package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class AddresnapMergerEmplis extends InfoMergerTemplate_<AddresnapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor_<AddresnapInfo, EmplisInfo> getVisitorHook() {
		return new AddresnapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
