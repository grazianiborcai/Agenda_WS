package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchSetterL2mNow;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiEnforceL2mNow extends ActionVisitorTemplateEnforce<CalontharchInfo> {
	
	public CalontharchVisiEnforceL2mNow(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}

	
	
	@Override protected CalontharchInfo enforceHook(CalontharchInfo recordInfo) {
		InfoSetter<CalontharchInfo> attrSetter = new CalontharchSetterL2mNow();
		return attrSetter.setAttr(recordInfo);
	}
}
