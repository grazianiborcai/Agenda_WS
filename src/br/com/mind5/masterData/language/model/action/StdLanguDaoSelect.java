package br.com.mind5.masterData.language.model.action;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdLanguDaoSelect extends ActionStdTemplateV2<LanguInfo> {

	public StdLanguDaoSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<LanguInfo> buildVisitorHook(DeciTreeOption<LanguInfo> option) {
		return new VisiLanguDaoSelect(option);
	}
}
