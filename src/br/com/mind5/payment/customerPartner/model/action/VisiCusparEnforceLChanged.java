package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparSetterLChanged;

final class VisiCusparEnforceLChanged extends ActionVisitorTemplateEnforce<CusparInfo> {
	
	public VisiCusparEnforceLChanged(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusparInfo enforceHook(CusparInfo recordInfo) {
		InfoSetter<CusparInfo> setter = new CusparSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
