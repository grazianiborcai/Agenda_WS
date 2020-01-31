package br.com.mind5.business.materialTextSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextarchMergerToSelect extends InfoMergerTemplate_<MatextarchInfo, MatextarchInfo> {

	@Override protected InfoMergerVisitor_<MatextarchInfo, MatextarchInfo> getVisitorHook() {
		return new MatextarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextarchInfo> getUniquifierHook() {
		return new MatextarchUniquifier();
	}
}
