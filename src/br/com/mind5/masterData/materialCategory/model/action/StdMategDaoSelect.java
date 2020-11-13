package br.com.mind5.masterData.materialCategory.model.action;

import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMategDaoSelect extends ActionStdTemplate<MategInfo> {

	public StdMategDaoSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MategInfo> buildVisitorHook(DeciTreeOption<MategInfo> option) {
		return new VisiMategDaoSelect(option);
	}
}
