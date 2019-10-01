package br.com.gda.business.owner.info;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerFimg extends InfoMergerTemplate<OwnerInfo, FimgInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, FimgInfo> getVisitorHook() {
		return new OwnerVisiMergeFimg();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
