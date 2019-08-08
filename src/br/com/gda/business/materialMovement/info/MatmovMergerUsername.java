package br.com.gda.business.materialMovement.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class MatmovMergerUsername extends InfoMergerTemplate<MatmovInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, UsernameInfo> getVisitorHook() {
		return new MatmovVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
