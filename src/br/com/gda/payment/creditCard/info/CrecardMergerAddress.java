package br.com.gda.payment.creditCard.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CrecardMergerAddress extends InfoMergerTemplate<CrecardInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<CrecardInfo, AddressInfo> getVisitorHook() {
		return new CrecardVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
