package br.com.mind5.masterData.materialGroupOwner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowSetterRgbDec;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupowVisiEnforceRgbDec extends ActionVisitorTemplateEnforce<MatoupowInfo> {
	
	public MatoupowVisiEnforceRgbDec(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatoupowInfo enforceHook(MatoupowInfo recordInfo) {
		InfoSetter<MatoupowInfo> attrSetter = new MatoupowSetterRgbDec();
		return attrSetter.setAttr(recordInfo);
	}
}
