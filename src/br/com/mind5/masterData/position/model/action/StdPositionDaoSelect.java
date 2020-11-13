package br.com.mind5.masterData.position.model.action;

import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPositionDaoSelect extends ActionStdTemplate<PositionInfo> {

	public StdPositionDaoSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PositionInfo> buildVisitorHook(DeciTreeOption<PositionInfo> option) {
		return new VisiPositionDaoSelect(option);
	}
}
