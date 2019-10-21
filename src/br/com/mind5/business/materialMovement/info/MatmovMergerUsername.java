package br.com.mind5.business.materialMovement.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatmovMergerUsername extends InfoMergerTemplate<MatmovInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, UsernameInfo> getVisitorHook() {
		return new MatmovVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
