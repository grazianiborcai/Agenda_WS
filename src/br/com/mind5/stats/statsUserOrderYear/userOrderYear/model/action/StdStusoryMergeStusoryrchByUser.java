package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;

public final class StdStusoryMergeStusoryrchByUser extends ActionStdTemplate<StusoryInfo> {

	public StdStusoryMergeStusoryrchByUser(DeciTreeOption<StusoryInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoryInfo> buildVisitorHook(DeciTreeOption<StusoryInfo> option) {
		return new VisiStusoryMergeStusoryrchByUser(option);
	}
}
