package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatextMergerUsername extends InfoMergerTemplate_<MatextInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<MatextInfo, UsernameInfo> getVisitorHook() {
		return new MatextVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
