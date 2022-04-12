package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckAuthOwner;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefupolNodeEvaluateL2 extends DeciTreeTemplateWrite<RefupolInfo> {
	
	public RefupolNodeEvaluateL2(DeciTreeOption<RefupolInfo> option) {
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
		checker = new RefupolCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStd<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupolInfo> success = new ActionStdSuccessCommom<RefupolInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefupolInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStd<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupolInfo> nodeL3 = new RefupolNodeEvaluateL3(option).toAction();
		
		actions.add(nodeL3);
		return actions;
	}
}
