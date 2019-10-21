package br.com.mind5.webhook.moipMultipayment.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class WokaymoipMergerDaemon extends InfoMergerTemplate<WokaymoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor<WokaymoipInfo, UserInfo> getVisitorHook() {
		return new WokaymoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokaymoipInfo> getUniquifierHook() {
		return new WokaymoipUniquifier();
	}
}
