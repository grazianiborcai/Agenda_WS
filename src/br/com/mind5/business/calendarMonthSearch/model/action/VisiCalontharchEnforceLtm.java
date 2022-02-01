package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchSetterLtm;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalontharchEnforceLtm extends ActionVisitorTemplateEnforce<CalontharchInfo> {
	
	public VisiCalontharchEnforceLtm(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}

	
	
	@Override protected CalontharchInfo enforceHook(CalontharchInfo recordInfo) {
		InfoSetter<CalontharchInfo> attrSetter = new CalontharchSetterLtm();
		return attrSetter.setAttr(recordInfo);
	}
}
