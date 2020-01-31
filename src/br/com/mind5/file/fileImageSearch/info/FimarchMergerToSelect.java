package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimarchMergerToSelect extends InfoMergerTemplate_<FimarchInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor_<FimarchInfo, FimarchInfo> getVisitorHook() {
		return new FimarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimarchInfo> getUniquifierHook() {
		return new FimarchUniquifier();
	}
}
