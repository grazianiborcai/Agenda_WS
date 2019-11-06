package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposMergeToDelete;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootDelete;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceEmpKey;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDeleteByEmp;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckHasEmpItem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmposDeleteByEmp extends DeciTreeWriteTemplate<EmposInfo> {
	
	public RootEmposDeleteByEmp(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildDecisionCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmposCheckDeleteByEmp(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckHasEmpItem(checkerOption);
		queue.add(checker);	

		return new ModelCheckerQueue<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> enforceEmpKey = new StdEmposEnforceEmpKey(option);
		ActionLazy<EmposInfo> mergeToDelete = new LazyEmposMergeToDelete(option.conn, option.schemaName);
		ActionLazy<EmposInfo> rootDelete = new LazyEmposRootDelete(option.conn, option.schemaName);
		
		enforceEmpKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(enforceEmpKey);
		return actions;
	}
}
