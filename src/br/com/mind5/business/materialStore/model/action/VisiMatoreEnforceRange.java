package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreSetterRange;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreEnforceRange extends ActionVisitorTemplateEnforce<MatoreInfo> {
	
	public VisiMatoreEnforceRange(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatoreInfo enforceHook(MatoreInfo recordInfo) {
		InfoSetter<MatoreInfo> attrSetter = new MatoreSetterRange();
		return attrSetter.setAttr(recordInfo);
	}
}
