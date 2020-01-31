package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CusparMergerSetupar extends InfoMergerTemplate_<CusparInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, SetuparInfo> getVisitorHook() {
		return new CusparVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
