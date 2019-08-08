package br.com.gda.business.material.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class MatMergerUsername extends InfoMergerTemplate<MatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatInfo, UsernameInfo> getVisitorHook() {
		return new MatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
