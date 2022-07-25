package br.com.mind5.discount.discountStoreSearch.model.action;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchSetterStrategyFirstTime;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchVisiEnforceStrategyFirstTime extends ActionVisitorTemplateEnforce<DisorarchInfo> {
	
	public DisorarchVisiEnforceStrategyFirstTime(DeciTreeOption<DisorarchInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisorarchInfo enforceHook(DisorarchInfo recordInfo) {
		InfoSetter<DisorarchInfo> attrSetter = new DisorarchSetterStrategyFirstTime();
		return attrSetter.setAttr(recordInfo);
	}
}
