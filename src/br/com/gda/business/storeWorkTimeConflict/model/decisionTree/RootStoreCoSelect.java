package br.com.gda.business.storeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckRead;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckSWT;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootStoreCoSelect extends DeciTreeReadTemplate<StoreCoInfo> {
	
	public RootStoreCoSelect(DeciTreeOption<StoreCoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreCoInfo> buildDecisionCheckerHook(DeciTreeOption<StoreCoInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoreCoInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreCoInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoreCoCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCoCheckSWT(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreCoInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreCoInfo> option) {
		List<ActionStd<StoreCoInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreCoInfo> actionRange = new ActionStoreCoMakeRange(option);
		ActionLazy<StoreCoInfo> actionSelect = new HandlerStoreCoSelect(option.conn, option.schemaName);
		actionRange.addPostAction(actionSelect);		
		actions.add(actionRange);
		
		return actions; 
	}
}
