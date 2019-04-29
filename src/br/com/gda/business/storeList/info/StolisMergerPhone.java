package br.com.gda.business.storeList.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerPhone extends InfoMergerTemplate<StolisInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<StolisInfo, PhoneInfo> getVisitorHook() {
		return new StolisVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
