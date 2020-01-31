package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class OwnerMergerUsername extends InfoMergerTemplate_<OwnerInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, UsernameInfo> getVisitorHook() {
		return new OwnerVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
