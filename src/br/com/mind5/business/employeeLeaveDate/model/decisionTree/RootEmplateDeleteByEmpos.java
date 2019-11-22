package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateRootDelete;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateMergeEmplarch;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckDeleteByEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmplateDeleteByEmpos extends DeciTreeWriteTemplate<EmplateInfo> {
	
	public RootEmplateDeleteByEmpos(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplateCheckDeleteByEmpos(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<EmplateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> mergeEmplarch = new StdEmplateMergeEmplarch(option);
		ActionLazy<EmplateInfo> delete = new LazyEmplateRootDelete(option.conn, option.schemaName);
		
		mergeEmplarch.addPostAction(delete);
		
		actions.add(mergeEmplarch);
		return actions;	
	}
}
