package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordSetterZerofy;

public final class SowordVisiEnforceZerofy extends ActionVisitorTemplateEnforce<SowordInfo> {
	
	public SowordVisiEnforceZerofy(DeciTreeOption<SowordInfo> option) {
		super(option);
	}

	
	
	@Override protected SowordInfo enforceHook(SowordInfo recordInfo) {
		InfoSetter<SowordInfo> attrSetter = new SowordSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
