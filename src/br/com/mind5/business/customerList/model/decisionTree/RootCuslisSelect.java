package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisMergePersolis;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeToSelect;
import br.com.mind5.business.customerList.model.checker.CuslisCheckLangu;
import br.com.mind5.business.customerList.model.checker.CuslisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCuslisSelect extends DeciTreeReadTemplate<CuslisInfo> {
	
	public RootCuslisSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildDecisionCheckerHook(DeciTreeOption<CuslisInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new CuslisCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CuslisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStd<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStd<CuslisInfo> select = new StdCuslisMergeToSelect(option);
		ActionLazy<CuslisInfo> mergePersolis = new LazyCuslisMergePersolis(option.conn, option.schemaName);
		
		select.addPostAction(mergePersolis);
		
		actions.add(select);
		return actions;
	}
}
