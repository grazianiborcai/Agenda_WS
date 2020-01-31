package br.com.mind5.file.fileImage.info;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimgMergerFimarch extends InfoMergerTemplate_<FimgInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor_<FimgInfo, FimarchInfo> getVisitorHook() {
		return new FimgVisiMergeFimarch();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
