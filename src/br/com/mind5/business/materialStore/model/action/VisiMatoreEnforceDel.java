package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiMatoreEnforceDel extends ActionVisitorTemplateEnforce<MatoreInfo> {
	
	@Override protected MatoreInfo enforceHook(MatoreInfo recordInfo) {
		InfoSetter<MatoreInfo> attrSetter = new MatoreSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
