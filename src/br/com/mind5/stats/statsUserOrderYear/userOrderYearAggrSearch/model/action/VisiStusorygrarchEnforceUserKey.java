package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchSetterUserKey;

final class VisiStusorygrarchEnforceUserKey extends ActionVisitorTemplateEnforce<StusorygrarchInfo> {
	
	public VisiStusorygrarchEnforceUserKey(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorygrarchInfo enforceHook(StusorygrarchInfo recordInfo) {
		InfoSetter<StusorygrarchInfo> attrSetter = new StusorygrarchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
