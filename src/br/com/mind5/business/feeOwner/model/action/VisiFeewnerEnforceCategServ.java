package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.business.feeOwner.info.FeewnerSetterCategServ;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeewnerEnforceCategServ extends ActionVisitorTemplateEnforceV2<FeewnerInfo> {
	
	public VisiFeewnerEnforceCategServ(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FeewnerInfo enforceHook(FeewnerInfo recordInfo) {
		InfoSetter<FeewnerInfo> setter = new FeewnerSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
