package br.com.mind5.masterData.gender.model.action;

import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGenderDaoSelect extends ActionStdTemplateV2<GenderInfo> {

	public StdGenderDaoSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<GenderInfo> buildVisitorHook(DeciTreeOption<GenderInfo> option) {
		return new VisiGenderDaoSelect(option);
	}
}
