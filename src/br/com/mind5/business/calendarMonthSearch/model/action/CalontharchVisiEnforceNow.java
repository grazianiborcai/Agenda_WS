package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchSetterNow;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiEnforceNow extends ActionVisitorTemplateEnforce<CalontharchInfo> {
	
	public CalontharchVisiEnforceNow(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}

	
	
	@Override protected CalontharchInfo enforceHook(CalontharchInfo recordInfo) {
		InfoSetter<CalontharchInfo> attrSetter = new CalontharchSetterNow();
		return attrSetter.setAttr(recordInfo);
	}
}
