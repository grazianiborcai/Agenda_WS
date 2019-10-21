package br.com.mind5.payment.creditCard.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CrecardMergerAddress extends InfoMergerTemplate<CrecardInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, AddressInfo> getVisitorHook() {
		return new CrecardVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
