package br.com.mind5.business.owner.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerFimist extends InfoMergerTemplate<OwnerInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, FimistInfo> getVisitorHook() {
		return new OwnerVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
