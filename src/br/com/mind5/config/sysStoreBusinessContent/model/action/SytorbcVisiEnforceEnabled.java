package br.com.mind5.config.sysStoreBusinessContent.model.action;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytorbcVisiEnforceEnabled extends ActionVisitorTemplateEnforce<SytorbcInfo> {
	
	public SytorbcVisiEnforceEnabled(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}

	
	
	@Override protected SytorbcInfo enforceHook(SytorbcInfo recordInfo) {
		InfoSetter<SytorbcInfo> attrSetter = new SytorbcSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
