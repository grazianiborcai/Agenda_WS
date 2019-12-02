package br.com.mind5.business.materialTextSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextarchMergerToSelect extends InfoMergerTemplate<MatextarchInfo, MatextarchInfo> {

	@Override protected InfoMergerVisitor<MatextarchInfo, MatextarchInfo> getVisitorHook() {
		return new MatextarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextarchInfo> getUniquifierHook() {
		return new MatextarchUniquifier();
	}
}
