package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpmatMergerUsername extends InfoMergerTemplate<EmpmatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmpmatInfo, UsernameInfo> getVisitorHook() {
		return new EmpmatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
