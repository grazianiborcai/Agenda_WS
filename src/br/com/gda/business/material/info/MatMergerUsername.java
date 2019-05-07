package br.com.gda.business.material.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class MatMergerUsername extends InfoMergerTemplate<MatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, UsernameInfo> getVisitorHook() {
		return new MatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
