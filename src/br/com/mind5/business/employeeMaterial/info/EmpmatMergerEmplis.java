package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerEmplis extends InfoMergerTemplate<EmpmatInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmplisInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
