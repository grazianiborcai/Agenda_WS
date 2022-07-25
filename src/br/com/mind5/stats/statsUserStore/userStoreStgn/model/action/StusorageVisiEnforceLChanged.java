package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageSetterLChanged;

public final class StusorageVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StusorageInfo> {
	
	public StusorageVisiEnforceLChanged(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorageInfo enforceHook(StusorageInfo recordInfo) {
		InfoSetter<StusorageInfo> attrSetter = new StusorageSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
