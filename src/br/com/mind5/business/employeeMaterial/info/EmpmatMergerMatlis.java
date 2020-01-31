package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatMergerMatlis extends InfoMergerTemplate_<EmpmatInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<EmpmatInfo, MatlisInfo> getVisitorHook() {
		return new EmpmatVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
