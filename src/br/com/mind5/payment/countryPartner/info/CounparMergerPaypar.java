package br.com.mind5.payment.countryPartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CounparMergerPaypar extends InfoMergerTemplate_<CounparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<CounparInfo,  PayparInfo> getVisitorHook() {
		return new CounparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<CounparInfo> getUniquifierHook() {
		return new CounparUniquifier();
	}
}
