package br.com.gda.business.employee.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerPhone extends InfoMergerTemplate<EmpInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<EmpInfo, PhoneInfo> getVisitorHook() {
		return new EmpVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
