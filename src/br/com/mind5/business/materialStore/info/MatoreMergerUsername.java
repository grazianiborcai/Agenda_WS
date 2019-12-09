package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class MatoreMergerUsername extends InfoMergerTemplate<MatoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, UsernameInfo> getVisitorHook() {
		return new MatoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
