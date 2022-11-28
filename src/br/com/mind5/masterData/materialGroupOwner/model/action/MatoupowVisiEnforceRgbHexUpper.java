package br.com.mind5.masterData.materialGroupOwner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowSetterRgbHexUpper;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiEnforceRgbHexUpper extends ActionVisitorTemplateEnforce<MatoupowInfo> {
	
	public MatoupowVisiEnforceRgbHexUpper(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatoupowInfo enforceHook(MatoupowInfo recordInfo) {
		InfoSetter<MatoupowInfo> attrSetter = new MatoupowSetterRgbHexUpper();
		return attrSetter.setAttr(recordInfo);
	}
}
