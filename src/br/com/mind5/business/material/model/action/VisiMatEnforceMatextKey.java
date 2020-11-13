package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterMatextKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatEnforceMatextKey extends ActionVisitorTemplateEnforce<MatInfo> {
	
	public VisiMatEnforceMatextKey(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterMatextKey();
		return attrSetter.setAttr(recordInfo);
	}
}
