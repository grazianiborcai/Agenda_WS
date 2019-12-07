package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatMergerMatlis extends InfoMergerTemplate<EmpmatInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, MatlisInfo> getVisitorHook() {
		return new EmpmatVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
