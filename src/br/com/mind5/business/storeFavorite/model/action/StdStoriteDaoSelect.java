package br.com.mind5.business.storeFavorite.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class StdStoriteDaoSelect extends ActionStdTemplateV2<StoriteInfo> {

	public StdStoriteDaoSelect(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoriteInfo> buildVisitorHook(DeciTreeOption<StoriteInfo> option) {
		return new VisiStoriteDaoSelect(option);
	}
}