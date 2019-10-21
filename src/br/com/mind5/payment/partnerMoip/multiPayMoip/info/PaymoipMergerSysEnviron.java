package br.com.mind5.payment.partnerMoip.multiPayMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PaymoipMergerSysEnviron extends InfoMergerTemplate<PaymoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<PaymoipInfo, SysEnvironInfo> getVisitorHook() {
		return new PaymoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
