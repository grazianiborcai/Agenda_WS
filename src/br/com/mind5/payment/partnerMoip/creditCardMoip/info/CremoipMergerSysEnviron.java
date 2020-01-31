package br.com.mind5.payment.partnerMoip.creditCardMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CremoipMergerSysEnviron extends InfoMergerTemplate_<CremoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<CremoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CremoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
