package br.com.mind5.business.materialMovement.model.action;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatmovEnforceLChanged extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
