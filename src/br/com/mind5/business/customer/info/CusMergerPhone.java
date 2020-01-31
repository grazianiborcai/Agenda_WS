package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerPhone extends InfoMergerTemplate_<CusInfo, PhoneInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, PhoneInfo> getVisitorHook() {
		return new CusVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
