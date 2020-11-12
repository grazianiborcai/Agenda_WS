package br.com.mind5.business.feeDefault.model.action;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.info.FeedefSetterCategServ;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeedefEnforceCategServ extends ActionVisitorTemplateEnforceV2<FeedefInfo> {
	
	public VisiFeedefEnforceCategServ(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected FeedefInfo enforceHook(FeedefInfo recordInfo) {
		InfoSetter<FeedefInfo> setter = new FeedefSetterCategServ();
		return setter.setAttr(recordInfo);
	}
}
