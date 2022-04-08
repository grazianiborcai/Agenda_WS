package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiEnforceLChanged extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	public MatextVisiEnforceLChanged(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
