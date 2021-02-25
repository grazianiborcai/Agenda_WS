package br.com.mind5.stats.userOrderYearStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.model.checker.StusorygeCheckExist;


public final class NodeStusorygeUpsert extends DeciTreeTemplateWrite<StusorygeInfo> {
	
	public NodeStusorygeUpsert(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygeInfo> buildCheckerHook(DeciTreeOption<StusorygeInfo> option) {
		List<ModelChecker<StusorygeInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorygeCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> update = new RootStusorygeUpdate(option).toAction();
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnFailedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> insert = new RootStusorygeInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
