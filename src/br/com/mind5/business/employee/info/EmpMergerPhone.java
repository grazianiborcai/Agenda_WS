package br.com.mind5.business.employee.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerPhone extends InfoMergerTemplate<EmpInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, PhoneInfo> getVisitorHook() {
		return new EmpVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
