package br.com.mind5.masterData.position.model.action;

import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPositionDaoSelect extends ActionStdTemplateV2<PositionInfo> {

	public StdPositionDaoSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PositionInfo> buildVisitorHook(DeciTreeOption<PositionInfo> option) {
		return new VisiPositionDaoSelect(option);
	}
}
