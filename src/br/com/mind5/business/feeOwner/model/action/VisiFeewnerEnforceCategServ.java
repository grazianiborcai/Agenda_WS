package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerSetterCategServ;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiFeewnerEnforceCategServ extends ActionVisitorTemplateEnforceV1<FeewnerInfo> {
	
	@Override protected FeewnerInfo enforceHook(FeewnerInfo recordInfo) {
		InfoSetter<FeewnerInfo> setter = new FeewnerSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
