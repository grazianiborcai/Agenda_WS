package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusparMergerAddresnap extends InfoMergerTemplate_<CusparInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, AddresnapInfo> getVisitorHook() {
		return new CusparVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
