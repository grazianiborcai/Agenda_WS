package br.com.mind5.business.material.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatMergerUsername extends InfoMergerTemplate_<MatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, UsernameInfo> getVisitorHook() {
		return new MatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
