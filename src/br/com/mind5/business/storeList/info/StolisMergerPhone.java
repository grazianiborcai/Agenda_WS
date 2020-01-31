package br.com.mind5.business.storeList.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerPhone extends InfoMergerTemplate_<StolisInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, PhoneInfo> getVisitorHook() {
		return new StolisVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
