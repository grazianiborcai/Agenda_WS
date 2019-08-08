package br.com.gda.business.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

public final class CusMergerUsername extends InfoMergerTemplate<CusInfo, UsernameInfo>{

	@Override protected InfoMergerVisitor<CusInfo, UsernameInfo> getVisitorHook() {
		return new CusVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
