package br.com.gda.business.employeeMaterial.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpmatMergerEmp extends InfoMergerTemplate<EmpmatInfo, EmpInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, EmpInfo> getVisitorHook() {
		return new EmpmatVisiMergeEmp();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
