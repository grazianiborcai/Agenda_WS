package br.com.mind5.business.materialMovement.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatmovMergerUsername extends InfoMergerTemplate_<MatmovInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<MatmovInfo, UsernameInfo> getVisitorHook() {
		return new MatmovVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
