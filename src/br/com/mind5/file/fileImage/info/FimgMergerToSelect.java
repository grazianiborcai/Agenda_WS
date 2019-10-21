package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class FimgMergerToSelect extends InfoMergerTemplate<FimgInfo, FimgInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FimgInfo> getVisitorHook() {
		return new FimgVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
