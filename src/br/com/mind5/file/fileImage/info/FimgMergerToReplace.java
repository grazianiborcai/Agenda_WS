package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimgMergerToReplace extends InfoMergerTemplate_<FimgInfo, FimgInfo> {

	@Override protected InfoMergerVisitor_<FimgInfo, FimgInfo> getVisitorHook() {
		return new FimgVisiMergeToReplace();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
