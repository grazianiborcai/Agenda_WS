package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiEnforceLChanged extends ActionVisitorTemplateEnforce<MatInfo> {
	
	public MatVisiEnforceLChanged(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
