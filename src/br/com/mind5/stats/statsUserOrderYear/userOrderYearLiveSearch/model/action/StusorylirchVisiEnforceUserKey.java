package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchSetterUserKey;

public final class StusorylirchVisiEnforceUserKey extends ActionVisitorTemplateEnforce<StusorylirchInfo> {
	
	public StusorylirchVisiEnforceUserKey(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorylirchInfo enforceHook(StusorylirchInfo recordInfo) {
		InfoSetter<StusorylirchInfo> attrSetter = new StusorylirchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
