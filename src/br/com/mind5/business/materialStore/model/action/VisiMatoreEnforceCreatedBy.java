package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreEnforceCreatedBy extends ActionVisitorTemplateEnforce<MatoreInfo> {
	
	public VisiMatoreEnforceCreatedBy(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatoreInfo enforceHook(MatoreInfo recordInfo) {
		InfoSetter<MatoreInfo> attrSetter = new MatoreSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
