package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	public MatmovVisiEnforceCreatedBy(DeciTreeOption<MatmovInfo> option) {
		super(option);		
	}
	
	
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
