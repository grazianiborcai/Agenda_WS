package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<MatInfo> {
	
	public MatVisiEnforceCreatedBy(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatInfo enforceHook(MatInfo recordInfo) {
		InfoSetter<MatInfo> attrSetter = new MatSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
