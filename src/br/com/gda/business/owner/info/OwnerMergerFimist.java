package br.com.gda.business.owner.info;

import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerFimist extends InfoMergerTemplate<OwnerInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, FimistInfo> getVisitorHook() {
		return new OwnerVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
