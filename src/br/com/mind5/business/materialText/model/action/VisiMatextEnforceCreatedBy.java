package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextEnforceCreatedBy extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	public VisiMatextEnforceCreatedBy(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
