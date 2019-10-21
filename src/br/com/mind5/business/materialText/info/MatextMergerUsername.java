package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatextMergerUsername extends InfoMergerTemplate<MatextInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatextInfo, UsernameInfo> getVisitorHook() {
		return new MatextVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
