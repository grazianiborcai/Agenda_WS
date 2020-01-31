package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextMergerMatextarch extends InfoMergerTemplate_<MatextInfo, MatextarchInfo> {

	@Override protected InfoMergerVisitor_<MatextInfo, MatextarchInfo> getVisitorHook() {
		return new MatextVisiMergeMatextarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
