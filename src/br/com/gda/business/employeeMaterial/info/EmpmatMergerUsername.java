package br.com.gda.business.employeeMaterial.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpmatMergerUsername extends InfoMergerTemplate<EmpmatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<EmpmatInfo, UsernameInfo> getVisitorHook() {
		return new EmpmatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmatInfo> getUniquifierHook() {
		return new EmpmatUniquifier();
	}
}
