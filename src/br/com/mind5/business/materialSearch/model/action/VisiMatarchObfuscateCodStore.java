package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterCodStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchObfuscateCodStore extends ActionVisitorTemplateEnforce<MatarchInfo> {
	
	public VisiMatarchObfuscateCodStore(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterCodStore();
		return attrSetter.setAttr(recordInfo);
	}
}
