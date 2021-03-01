package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;

public final class StdStusoryliMergeToSelect extends ActionStdTemplate<StusoryliInfo> {

	public StdStusoryliMergeToSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoryliInfo> buildVisitorHook(DeciTreeOption<StusoryliInfo> option) {
		return new VisiStusoryliMergeToSelect(option);
	}
}
