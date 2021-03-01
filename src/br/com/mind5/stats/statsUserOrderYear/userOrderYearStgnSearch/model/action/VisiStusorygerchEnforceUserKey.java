package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchSetterUserKey;

final class VisiStusorygerchEnforceUserKey extends ActionVisitorTemplateEnforce<StusorygerchInfo> {
	
	public VisiStusorygerchEnforceUserKey(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorygerchInfo enforceHook(StusorygerchInfo recordInfo) {
		InfoSetter<StusorygerchInfo> attrSetter = new StusorygerchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
