package br.com.gda.business.materialMovement.model.action;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.info.MatmovSetterPostingDate;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatmovEnforcePostingDate extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterPostingDate();
		return attrSetter.setAttr(recordInfo);
	}
}
