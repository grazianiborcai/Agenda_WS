package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimarchMergerToSelect extends InfoMergerTemplate<FimarchInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor<FimarchInfo, FimarchInfo> getVisitorHook() {
		return new FimarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimarchInfo> getUniquifierHook() {
		return new FimarchUniquifier();
	}
}
