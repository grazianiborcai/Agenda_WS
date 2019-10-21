package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusparMergerAddresnap extends InfoMergerTemplate<CusparInfo, AddresnapInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, AddresnapInfo> getVisitorHook() {
		return new CusparVisiMergeAddresnap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
