package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CremoipMergerSysEnviron extends InfoMergerTemplate<CremoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<CremoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CremoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
