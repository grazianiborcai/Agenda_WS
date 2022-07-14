package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchSetterUserKey;

public final class StusorygerchVisiEnforceUserKey extends ActionVisitorTemplateEnforce<StusorygerchInfo> {
	
	public StusorygerchVisiEnforceUserKey(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorygerchInfo enforceHook(StusorygerchInfo recordInfo) {
		InfoSetter<StusorygerchInfo> attrSetter = new StusorygerchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
