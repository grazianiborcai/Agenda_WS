package br.com.gda.file.fileImage.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class FimgMergerToUpdate extends InfoMergerTemplate<FimgInfo, FimgInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, FimgInfo> getVisitorHook() {
		return new FimgVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
