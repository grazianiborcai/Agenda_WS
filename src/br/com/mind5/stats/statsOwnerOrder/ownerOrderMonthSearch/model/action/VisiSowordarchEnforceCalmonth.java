package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchSetterCalmonth;

final class VisiSowordarchEnforceCalmonth extends ActionVisitorTemplateEnforce<SowordarchInfo> {
	
	public VisiSowordarchEnforceCalmonth(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordarchInfo enforceHook(SowordarchInfo recordInfo) {
		InfoSetter<SowordarchInfo> attrSetter = new SowordarchSetterCalmonth();
		return attrSetter.setAttr(recordInfo);
	}
}
