package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class FimgMergerUsername extends InfoMergerTemplate_<FimgInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<FimgInfo, UsernameInfo> getVisitorHook() {
		return new FimgVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
