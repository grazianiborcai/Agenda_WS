package br.com.mind5.masterData.gender.model.action;

import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGenderDaoSelect extends ActionStdTemplate<GenderInfo> {

	public StdGenderDaoSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<GenderInfo> buildVisitorHook(DeciTreeOption<GenderInfo> option) {
		return new VisiGenderDaoSelect(option);
	}
}
