package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchSetterCalmonth;

public final class SowusarchVisiEnforceCalmonth extends ActionVisitorTemplateEnforce<SowusarchInfo> {
	
	public SowusarchVisiEnforceCalmonth(DeciTreeOption<SowusarchInfo> option) {
		super(option);
	}

	
	
	@Override protected SowusarchInfo enforceHook(SowusarchInfo recordInfo) {
		InfoSetter<SowusarchInfo> attrSetter = new SowusarchSetterCalmonth();
		return attrSetter.setAttr(recordInfo);
	}
}
