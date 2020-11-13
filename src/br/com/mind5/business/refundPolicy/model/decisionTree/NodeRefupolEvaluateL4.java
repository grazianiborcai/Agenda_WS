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
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeRefupolEvaluateL4 extends DeciTreeTemplateWriteV2<RefupolInfo> {
	
	public NodeRefupolEvaluateL4(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupolInfo> buildCheckerHook(DeciTreeOption<RefupolInfo> option) {
		List<ModelCheckerV1<RefupolInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupolInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckEvaluateService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStdV2<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefupolInfo> mergeRefupore = new StdRefupolMergeRefupore(option);
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
