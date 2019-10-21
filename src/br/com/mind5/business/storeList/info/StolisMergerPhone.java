package br.com.mind5.business.storeList.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerPhone extends InfoMergerTemplate<StolisInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, PhoneInfo> getVisitorHook() {
		return new StolisVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
