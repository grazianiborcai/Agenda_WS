package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovSetterPostingDate;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatmovEnforcePostingDate extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterPostingDate();
		return attrSetter.setAttr(recordInfo);
	}
}
