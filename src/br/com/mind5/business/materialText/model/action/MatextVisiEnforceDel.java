package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextVisiEnforceDel extends ActionVisitorTemplateEnforce<MatextInfo> {
	
	public MatextVisiEnforceDel(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatextInfo enforceHook(MatextInfo recordInfo) {
		InfoSetter<MatextInfo> attrSetter = new MatextSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
