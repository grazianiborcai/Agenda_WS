package br.com.mind5.stats.userOrderYearStgn.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeSetterLChanged;

final class VisiStusorygeEnforceLChanged extends ActionVisitorTemplateEnforce<StusorygeInfo> {
	
	public VisiStusorygeEnforceLChanged(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}

	
	
	@Override protected StusorygeInfo enforceHook(StusorygeInfo recordInfo) {
		InfoSetter<StusorygeInfo> attrSetter = new StusorygeSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
