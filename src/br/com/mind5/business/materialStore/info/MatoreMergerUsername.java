package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatoreMergerUsername extends InfoMergerTemplate_<MatoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, UsernameInfo> getVisitorHook() {
		return new MatoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
