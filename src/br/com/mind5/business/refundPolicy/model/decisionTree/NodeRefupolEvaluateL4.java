package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.action.LazyRefupolEnforceHasPassed;
import br.com.mind5.business.refundPolicy.model.action.LazyRefupolEnforceRHour;
import br.com.mind5.business.refundPolicy.model.action.LazyRefupolNodeEvaluateL5;
import br.com.mind5.business.refundPolicy.model.action.StdRefupolMergeRefupore;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckEvaluateService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeRefupolEvaluateL4 extends DeciTreeTemplateWrite<RefupolInfo> {
	
	public NodeRefupolEvaluateL4(DeciTreeOption<RefupolInfo> option) {
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
		checker = new RefupolCheckEvaluateService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStd<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupolInfo> mergeRefupore = new StdRefupolMergeRefupore(option);
		ActionLazy<RefupolInfo> enforceRHour = new LazyRefupolEnforceRHour(option.conn, option.schemaName);
		ActionLazy<RefupolInfo> enfoerceHasPassed = new LazyRefupolEnforceHasPassed(option.conn, option.schemaName);
		ActionLazy<RefupolInfo> nodeL5 = new LazyRefupolNodeEvaluateL5(option.conn, option.schemaName);
		
		mergeRefupore.addPostAction(enforceRHour);
		enforceRHour.addPostAction(enfoerceHasPassed);
		enfoerceHasPassed.addPostAction(nodeL5);
		
		actions.add(mergeRefupore);
		return actions;
	}
}
