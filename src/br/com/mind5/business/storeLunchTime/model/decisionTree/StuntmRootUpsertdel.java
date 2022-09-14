package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckFlagDel;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmNodeUpsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmRootUpsertdel extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmRootUpsertdel(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmCheckFlagDel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();		
		
		ActionStd<StuntmInfo> delete = new StuntmRootDeleteIfExist(option).toAction();
		
		actions.add(delete);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnFailedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();		
		
		ActionStd<StuntmInfo> upsert = new StuntmNodeUpsert(option).toAction();
		
		actions.add(upsert);	
		return actions;
	}
}
