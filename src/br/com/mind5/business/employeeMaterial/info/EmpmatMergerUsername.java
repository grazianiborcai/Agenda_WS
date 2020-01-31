package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpmatMergerUsername extends InfoMergerTemplate_<EmpmatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<EmpmatInfo, UsernameInfo> getVisitorHook() {
		return new EmpmatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
