package br.com.gda.file.fileImage.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class FimgMergerUsername extends InfoMergerTemplate<FimgInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, UsernameInfo> getVisitorHook() {
		return new FimgVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
