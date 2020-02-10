package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PaymoipMergerSysEnviron extends InfoMergerTemplate_<PaymoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<PaymoipInfo, SysEnvironInfo> getVisitorHook() {
		return new PaymoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
