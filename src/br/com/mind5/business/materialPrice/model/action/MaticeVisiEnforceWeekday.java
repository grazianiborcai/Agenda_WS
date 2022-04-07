package br.com.mind5.business.materialPrice.model.action;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.info.MaticeSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MaticeVisiEnforceWeekday extends ActionVisitorTemplateEnforce<MaticeInfo> {
	
	public MaticeVisiEnforceWeekday(DeciTreeOption<MaticeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MaticeInfo enforceHook(MaticeInfo recordInfo) {
		InfoSetter<MaticeInfo> setter = new MaticeSetterWeekday();
		return setter.setAttr(recordInfo);
	}
}
