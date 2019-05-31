package br.com.gda.business.feeOwner.model.action;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.info.FeewnerSetterCategServ;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFeewnerEnforceCategServ extends ActionVisitorTemplateEnforce<FeewnerInfo> {
	
	@Override protected FeewnerInfo enforceHook(FeewnerInfo recordInfo) {
		InfoSetter<FeewnerInfo> setter = new FeewnerSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
