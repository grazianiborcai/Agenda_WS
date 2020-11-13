package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateDaoInsert;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateDaoUpdate;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckSoftDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmplateInsert extends DeciTreeTemplateWrite<EmplateInfo> {
	
	public NodeEmplateInsert(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new EmplateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> insert = new StdEmplateDaoInsert(option);		
		actions.add(insert);				
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnFailedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> update = new StdEmplateDaoUpdate(option);		
		actions.add(update);	
		
		return actions;
	}
}
