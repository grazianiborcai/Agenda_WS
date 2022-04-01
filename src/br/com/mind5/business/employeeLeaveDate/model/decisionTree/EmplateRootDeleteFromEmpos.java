package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiRootDelete;
import br.com.mind5.business.employeeLeaveDate.model.action.EmplateVisiMergeEmplarch;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckDeleteFromEmpos;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplateRootDeleteFromEmpos extends DeciTreeTemplateWrite<EmplateInfo> {
	
	public EmplateRootDeleteFromEmpos(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplateCheckDeleteFromEmpos(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<EmplateInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> mergeEmplarch = new ActionStdCommom<EmplateInfo>(option, EmplateVisiMergeEmplarch.class);
		ActionLazy<EmplateInfo> delete = new ActionLazyCommom<EmplateInfo>(option, EmplateVisiRootDelete.class);
		
		mergeEmplarch.addPostAction(delete);
		
		actions.add(mergeEmplarch);
		return actions;	
	}
}
