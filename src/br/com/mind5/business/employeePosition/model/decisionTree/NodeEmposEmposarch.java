package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmplate;
import br.com.mind5.business.employeePosition.model.action.LazyEmposNodeDeleteEmpwotm;
import br.com.mind5.business.employeePosition.model.action.StdEmposSuccess;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckEmposarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmposEmposarch extends DeciTreeTemplateWrite<EmposInfo> {
	
	public NodeEmposEmposarch(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckEmposarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> success = new StdEmposSuccess(option);
		
		actions.add(success);
		return actions;		
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnFailedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> schedage = new NodeEmposSchedage(option).toAction();
		ActionLazy<EmposInfo> deleteEmplate = new LazyEmposNodeDeleteEmplate(option.conn, option.schemaName);
		ActionLazy<EmposInfo> deleteEmpwotm = new LazyEmposNodeDeleteEmpwotm(option.conn, option.schemaName);		
		
		schedage.addPostAction(deleteEmplate);
		schedage.addPostAction(deleteEmpwotm);
		
		
		actions.add(schedage);
		return actions;		
	}
}
