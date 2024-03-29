package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovSetterPostingDate;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovVisiEnforcePostingDate extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	public MatmovVisiEnforcePostingDate(DeciTreeOption<MatmovInfo> option) {
		super(option);		
	}
	
	
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterPostingDate();
		return attrSetter.setAttr(recordInfo);
	}
}
