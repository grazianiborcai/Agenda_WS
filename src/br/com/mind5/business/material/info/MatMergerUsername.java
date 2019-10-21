package br.com.mind5.business.material.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatMergerUsername extends InfoMergerTemplate<MatInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatInfo, UsernameInfo> getVisitorHook() {
		return new MatVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
