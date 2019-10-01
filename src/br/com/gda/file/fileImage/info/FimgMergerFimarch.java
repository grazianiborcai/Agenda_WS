package br.com.gda.file.fileImage.info;

import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FimgMergerFimarch extends InfoMergerTemplate<FimgInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FimarchInfo> getVisitorHook() {
		return new FimgVisiMergeFimarch();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
