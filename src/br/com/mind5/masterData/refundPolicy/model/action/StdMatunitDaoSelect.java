package br.com.mind5.masterData.refundPolicy.model.action;

import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatunitDaoSelect extends ActionStdTemplateV2<RefupoInfo> {

	public StdMatunitDaoSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefupoInfo> buildVisitorHook(DeciTreeOption<RefupoInfo> option) {
		return new VisiMatunitDaoSelect(option);
	}
}
