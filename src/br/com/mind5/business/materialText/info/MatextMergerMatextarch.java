package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextMergerMatextarch extends InfoMergerTemplate<MatextInfo, MatextarchInfo> {

	@Override protected InfoMergerVisitor<MatextInfo, MatextarchInfo> getVisitorHook() {
		return new MatextVisiMergeMatextarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
