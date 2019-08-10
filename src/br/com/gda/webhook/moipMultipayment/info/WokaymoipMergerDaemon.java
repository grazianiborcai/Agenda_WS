package br.com.gda.webhook.moipMultipayment.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class WokaymoipMergerDaemon extends InfoMergerTemplate<WokaymoipInfo, UserInfo> {

	@Override protected InfoMergerVisitor<WokaymoipInfo, UserInfo> getVisitorHook() {
		return new WokaymoipVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<WokaymoipInfo> getUniquifierHook() {
		return new WokaymoipUniquifier();
	}
}
