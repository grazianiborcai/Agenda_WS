package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OwnerMergerUsername extends InfoMergerTemplate<OwnerInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, UsernameInfo> getVisitorHook() {
		return new OwnerVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
