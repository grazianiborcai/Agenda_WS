package br.com.mind5.masterData.dayPartingSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.masterData.dayPartingSearch.model.action.StdDayparchDaoSelect;
import br.com.mind5.masterData.dayPartingSearch.model.checker.DayparchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDayparchSelect extends DeciTreeTemplateRead<DayparchInfo> {
	
	public RootDayparchSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DayparchInfo> buildCheckerHook(DeciTreeOption<DayparchInfo> option) {
		List<ModelChecker<DayparchInfo>> queue = new ArrayList<>();		
		ModelChecker<DayparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new DayparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<DayparchInfo>> buildActionsOnPassedHook(DeciTreeOption<DayparchInfo> option) {
		List<ActionStd<DayparchInfo>> actions = new ArrayList<>();
		
		ActionStd<DayparchInfo> select = new StdDayparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
