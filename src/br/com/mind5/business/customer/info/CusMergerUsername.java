package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusMergerUsername extends InfoMergerTemplate<CusInfo, UsernameInfo>{

	@Override protected InfoMergerVisitor<CusInfo, UsernameInfo> getVisitorHook() {
		return new CusVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
