package br.com.gda.file.fileImageSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FimarchMergerToSelect extends InfoMergerTemplate<FimarchInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor<FimarchInfo, FimarchInfo> getVisitorHook() {
		return new FimarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimarchInfo> getUniquifierHook() {
		return new FimarchUniquifier();
	}
}
