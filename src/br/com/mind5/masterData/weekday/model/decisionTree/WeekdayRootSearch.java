package br.com.mind5.masterData.weekday.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.WeekdayVisiMergeWeekdarch;
import br.com.mind5.masterData.weekday.model.action.WeekdayVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class WeekdayRootSearch extends DeciTreeTemplateWrite<WeekdayInfo> {
	
	public WeekdayRootSearch(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WeekdayInfo> buildCheckerHook(DeciTreeOption<WeekdayInfo> option) {
		List<ModelChecker<WeekdayInfo>> queue = new ArrayList<>();		
		ModelChecker<WeekdayInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<WeekdayInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdayInfo> option) {
		List<ActionStd<WeekdayInfo>> actions = new ArrayList<>();		
		
		ActionStd<WeekdayInfo> mergeWeekdarch =  new ActionStdCommom<WeekdayInfo>(option, WeekdayVisiMergeWeekdarch.class);		
		ActionLazy<WeekdayInfo> select = new ActionLazyCommom<WeekdayInfo>(option, WeekdayVisiRootSelect.class);
		
		mergeWeekdarch.addPostAction(select);
		
		actions.add(mergeWeekdarch);			
		return actions;
	}
}
