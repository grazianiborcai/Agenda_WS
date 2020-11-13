package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootDelete;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeEmposarch;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDeleteByEmp;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmposDeleteByEmp extends DeciTreeTemplateWrite<EmposInfo> {
	
	public RootEmposDeleteByEmp(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmposCheckDeleteByEmp(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> mergeEmposarch = new StdEmposMergeEmposarch(option);
		ActionLazy<EmposInfo> delete = new LazyEmposRootDelete(option.conn, option.schemaName);
		
		mergeEmposarch.addPostAction(delete);
		
		actions.add(mergeEmposarch);
		return actions;
	}
}
