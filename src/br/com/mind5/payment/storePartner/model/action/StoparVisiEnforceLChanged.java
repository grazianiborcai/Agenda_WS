package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparSetterLChanged;

public final class StoparVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StoparInfo> {
	
	public StoparVisiEnforceLChanged(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoparInfo enforceHook(StoparInfo recordInfo) {
		InfoSetter<StoparInfo> attrSetter = new StoparSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
