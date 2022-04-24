package br.com.mind5.business.storeLunchTime.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootInsert;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootUpdate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmNodeUpsert extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmNodeUpsert(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StuntmCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();		
		
		ActionStd<StuntmInfo> update = new StuntmRootUpdate(option).toAction();
		
		actions.add(update);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnFailedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();		
		
		ActionStd<StuntmInfo> insert = new StuntmRootInsert(option).toAction();
		
		actions.add(insert);	
		return actions;
	}
}
