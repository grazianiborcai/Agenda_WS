package br.com.mind5.file.fileImage.info;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimgMergerFimarch extends InfoMergerTemplate<FimgInfo, FimarchInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FimarchInfo> getVisitorHook() {
		return new FimgVisiMergeFimarch();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
