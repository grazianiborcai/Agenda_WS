package br.com.mind5.business.calendarMonthSearch.model.action;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.business.calendarMonthSearch.info.CalontharchSetterBeginEnd;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalontharchVisiEnforceBeginEnd extends ActionVisitorTemplateEnforce<CalontharchInfo> {
	
	public CalontharchVisiEnforceBeginEnd(DeciTreeOption<CalontharchInfo> option) {
		super(option);
	}

	
	
	@Override protected CalontharchInfo enforceHook(CalontharchInfo recordInfo) {
		InfoSetter<CalontharchInfo> attrSetter = new CalontharchSetterBeginEnd();
		return attrSetter.setAttr(recordInfo);
	}
}
