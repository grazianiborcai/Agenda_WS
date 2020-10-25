package br.com.mind5.config.sysStoreBusinessContent.model.action;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytorbcDaoSelect extends ActionStdTemplateV2<SytorbcInfo> {

	public StdSytorbcDaoSelect(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SytorbcInfo> buildVisitorHook(DeciTreeOption<SytorbcInfo> option) {
		return new VisiSytorbcDaoSelect(option);
	}
}
