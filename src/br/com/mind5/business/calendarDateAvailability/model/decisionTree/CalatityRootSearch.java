package br.com.mind5.business.calendarDateAvailability.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.calendarDateAvailability.model.action.CalatityVisiMergeCalate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalatityRootSearch extends DeciTreeTemplateRead<CalatityInfo> {
	
	public CalatityRootSearch(DeciTreeOption<CalatityInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalatityInfo> buildCheckerHook(DeciTreeOption<CalatityInfo> option) {
		List<ModelChecker<CalatityInfo>> queue = new ArrayList<>();		
		ModelChecker<CalatityInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalatityInfo>> buildActionsOnPassedHook(DeciTreeOption<CalatityInfo> option) {
		List<ActionStd<CalatityInfo>> actions = new ArrayList<>();
		
		ActionStd<CalatityInfo> mergeCalate = new ActionStdCommom<CalatityInfo>(option, CalatityVisiMergeCalate.class);
		
		actions.add(mergeCalate);
		return actions;
	}
}
