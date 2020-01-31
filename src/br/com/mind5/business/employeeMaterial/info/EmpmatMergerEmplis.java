package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatMergerEmplis extends InfoMergerTemplate_<EmpmatInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<EmpmatInfo, EmplisInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
