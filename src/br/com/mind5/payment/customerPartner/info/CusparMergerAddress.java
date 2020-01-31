package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusparMergerAddress extends InfoMergerTemplate_<CusparInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, AddressInfo> getVisitorHook() {
		return new CusparVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
