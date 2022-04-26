package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckFlagDel;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmRootUpsertdel extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmRootUpsertdel(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckFlagDel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmplutmInfo> delete = new EmplutmRootDelete(option).toAction();
		
		actions.add(delete);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmplutmInfo> upsert = new EmplutmNodeUpsert(option).toAction();
		
		actions.add(upsert);	
		return actions;
	}
}
