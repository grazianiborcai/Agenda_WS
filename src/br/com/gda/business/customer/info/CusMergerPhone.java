package br.com.gda.business.customer.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerPhone extends InfoMergerTemplate<CusInfo, PhoneInfo>{

	@Override protected InfoMergerVisitor<CusInfo, PhoneInfo> getVisitorHook() {
		return new CusVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
