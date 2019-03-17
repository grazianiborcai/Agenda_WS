package br.com.gda.business.materialMovement.model.action;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.info.MatmovSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiMatmovEnforceLChanged extends ActionVisitorTemplateEnforce<MatmovInfo> {
	
	@Override protected MatmovInfo enforceHook(MatmovInfo recordInfo) {
		InfoSetter<MatmovInfo> attrSetter = new MatmovSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
