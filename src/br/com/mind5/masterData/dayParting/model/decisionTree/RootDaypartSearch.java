package br.com.mind5.masterData.dayParting.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.action.LazyDaypartRootSelect;
import br.com.mind5.masterData.dayParting.model.action.StdDaypartMergeDayparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootDaypartSearch extends DeciTreeTemplateWrite<DaypartInfo> {
	
	public RootDaypartSearch(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DaypartInfo> buildCheckerHook(DeciTreeOption<DaypartInfo> option) {
		List<ModelChecker<DaypartInfo>> queue = new ArrayList<>();		
		ModelChecker<DaypartInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DaypartInfo>> buildActionsOnPassedHook(DeciTreeOption<DaypartInfo> option) {
		List<ActionStd<DaypartInfo>> actions = new ArrayList<>();		
		
		ActionStd<DaypartInfo> mergeDayparch = new StdDaypartMergeDayparch(option);		
		ActionLazy<DaypartInfo> select = new LazyDaypartRootSelect(option.conn, option.schemaName);
		
		mergeDayparch.addPostAction(select);
		
		actions.add(mergeDayparch);			
		return actions;
	}
}
