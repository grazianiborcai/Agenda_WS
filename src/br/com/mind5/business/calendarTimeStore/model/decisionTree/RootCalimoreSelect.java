package br.com.mind5.business.calendarTimeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.action.LazyCalimoreNodeSelect;
import br.com.mind5.business.calendarTimeStore.model.action.StdCalimoreMergeCalate;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckOwner;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckRead;
import br.com.mind5.business.calendarTimeStore.model.checker.CalimoreCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootCalimoreSelect extends DeciTreeTemplateWrite<CalimoreInfo> {
	
	public RootCalimoreSelect(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalimoreInfo> buildCheckerHook(DeciTreeOption<CalimoreInfo> option) {
		List<ModelChecker<CalimoreInfo>> queue = new ArrayList<>();		
		ModelChecker<CalimoreInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimoreCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalimoreInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimoreInfo> option) {
		List<ActionStd<CalimoreInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimoreInfo> mergeCalate = new StdCalimoreMergeCalate(option);
		ActionLazy<CalimoreInfo> select = new LazyCalimoreNodeSelect(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(select);
		
		actions.add(mergeCalate);
		return actions;
	}
}
