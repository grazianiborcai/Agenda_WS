package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeSetterLChanged;

public final class StusorygeVisiEnforceLChanged extends ActionVisitorTemplateEnforce<StusorygeInfo> {
	
	public StusorygeVisiEnforceLChanged(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorygeInfo enforceHook(StusorygeInfo recordInfo) {
		InfoSetter<StusorygeInfo> attrSetter = new StusorygeSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
