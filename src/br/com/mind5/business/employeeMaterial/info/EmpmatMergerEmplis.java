package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerEmp extends InfoMergerTemplate<EmpmatInfo, EmpInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmpInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmp();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
