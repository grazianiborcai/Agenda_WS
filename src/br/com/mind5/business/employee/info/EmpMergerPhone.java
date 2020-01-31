package br.com.mind5.business.employee.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerPhone extends InfoMergerTemplate_<EmpInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, PhoneInfo> getVisitorHook() {
		return new EmpVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
