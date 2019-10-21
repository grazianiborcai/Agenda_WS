package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerPhone extends InfoMergerTemplate<CusInfo, PhoneInfo>{

	@Override protected InfoMergerVisitor<CusInfo, PhoneInfo> getVisitorHook() {
		return new CusVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
