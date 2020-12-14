package br.com.mind5.stats.userStorePurchaseStgn.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageSetterLChanged;

final class VisiStusorageEnforceLChanged extends ActionVisitorTemplateEnforce<StusorageInfo> {
	
	public VisiStusorageEnforceLChanged(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorageInfo enforceHook(StusorageInfo recordInfo) {
		InfoSetter<StusorageInfo> attrSetter = new StusorageSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
