package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerPhone extends InfoMergerTemplate<EmpnapInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, PhoneInfo> getVisitorHook() {
		return new EmpnapVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
