package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;

public final class StdStusoryrchMergeStusorygerch extends ActionStdTemplate<StusoryrchInfo> {

	public StdStusoryrchMergeStusorygerch(DeciTreeOption<StusoryrchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoryrchInfo> buildVisitorHook(DeciTreeOption<StusoryrchInfo> option) {
		return new VisiStusoryrchMergeStusorygerch(option);
	}
}
