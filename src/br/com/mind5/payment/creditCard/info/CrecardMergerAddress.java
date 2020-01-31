package br.com.mind5.payment.creditCard.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CrecardMergerAddress extends InfoMergerTemplate_<CrecardInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, AddressInfo> getVisitorHook() {
		return new CrecardVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
