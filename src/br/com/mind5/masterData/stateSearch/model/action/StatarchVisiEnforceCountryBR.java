package br.com.mind5.masterData.stateSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.info.StatarchSetterCountryBR;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchVisiEnforceCountryBR extends ActionVisitorTemplateEnforce<StatarchInfo> {
	
	public StatarchVisiEnforceCountryBR(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}

	
	
	@Override protected StatarchInfo enforceHook(StatarchInfo recordInfo) {
		InfoSetter<StatarchInfo> attrSetter = new StatarchSetterCountryBR();
		return attrSetter.setAttr(recordInfo);
	}
}
