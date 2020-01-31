package br.com.mind5.webhook.moipMultipayment.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class WokaymoipMergerDaemon extends InfoMergerTemplate_<WokaymoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<WokaymoipInfo, UserInfo> getVisitorHook() {
		return new WokaymoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokaymoipInfo> getUniquifierHook() {
		return new WokaymoipUniquifier();
	}
}
