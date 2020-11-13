package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovEnforceCreatedOn extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	public VisiMatmovEnforceCreatedOn(DeciTreeOption<MatmovInfo> option) {
		super(option);		
	}
	
	
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
