package br.com.mind5.business.owner.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerFimist extends InfoMergerTemplate_<OwnerInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, FimistInfo> getVisitorHook() {
		return new OwnerVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
