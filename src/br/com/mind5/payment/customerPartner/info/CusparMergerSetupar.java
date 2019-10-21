package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CusparMergerSetupar extends InfoMergerTemplate<CusparInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, SetuparInfo> getVisitorHook() {
		return new CusparVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
