package br.com.mind5.masterData.weekday.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.LazyWeekdayRootSelect;
import br.com.mind5.masterData.weekday.model.action.StdWeekdayMergeWeekdarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootWeekdaySearch extends DeciTreeTemplateWrite<WeekdayInfo> {
	
	public RootWeekdaySearch(DeciTreeOption<WeekdayInfo> option) {
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
		
		ActionStd<WeekdayInfo> mergeWeekdarch = new StdWeekdayMergeWeekdarch(option);		
		ActionLazy<WeekdayInfo> select = new LazyWeekdayRootSelect(option.conn, option.schemaName);
		
		mergeWeekdarch.addPostAction(select);
		
		actions.add(mergeWeekdarch);			
		return actions;
	}
}
