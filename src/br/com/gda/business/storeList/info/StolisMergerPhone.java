package br.com.gda.business.storeList.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerPhone extends InfoMergerTemplate<StolisInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, PhoneInfo> getVisitorHook() {
		return new StolisVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
