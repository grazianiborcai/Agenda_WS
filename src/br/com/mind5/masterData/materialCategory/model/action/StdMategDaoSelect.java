package br.com.mind5.masterData.materialCategory.model.action;

import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMategDaoSelect extends ActionStdTemplateV2<MategInfo> {

	public StdMategDaoSelect(DeciTreeOption<MategInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MategInfo> buildVisitorHook(DeciTreeOption<MategInfo> option) {
		return new VisiMategDaoSelect(option);
	}
}
