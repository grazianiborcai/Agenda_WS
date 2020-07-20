package br.com.mind5.business.materialTextSnapshot.model.action;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapMergeToSelect extends ActionStdTemplateV2<MatextsnapInfo> {

	public StdMatextsnapMergeToSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatextsnapInfo> buildVisitorHook(DeciTreeOption<MatextsnapInfo> option) {
		return new VisiMatextsnapMergeToSelect(option);
	}
}
