package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiNodeEvaluateL1;
import br.com.mind5.business.refundPolicy.model.action.RefupolVisiMergeOrderem;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckEvaluate;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckOrderem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefupolRootEvaluate extends DeciTreeTemplateWrite<RefupolInfo> {
	
	public RefupolRootEvaluate(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefupolInfo> buildCheckerHook(DeciTreeOption<RefupolInfo> option) {
		List<ModelChecker<RefupolInfo>> queue = new ArrayList<>();		
		ModelChecker<RefupolInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckEvaluate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStd<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupolInfo> select = new ActionStdCommom<RefupolInfo>(option, RefupolVisiMergeOrderem.class);
		ActionLazy<RefupolInfo> nodeL1 = new ActionLazyCommom<RefupolInfo>(option, RefupolVisiNodeEvaluateL1.class);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
