package br.com.mind5.payment.partnerMoip.creditCardMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CremoipMergerSysEnviron extends InfoMergerTemplate<CremoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<CremoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CremoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
