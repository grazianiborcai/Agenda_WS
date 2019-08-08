package br.com.gda.business.owner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class OwnerMergerUsername extends InfoMergerTemplate<OwnerInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, UsernameInfo> getVisitorHook() {
		return new OwnerVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
