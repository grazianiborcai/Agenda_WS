package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class FimgMergerUsername extends InfoMergerTemplate<FimgInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<FimgInfo, UsernameInfo> getVisitorHook() {
		return new FimgVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<FimgInfo> getUniquifierHook() {
		return new FimgUniquifier();
	}
}
