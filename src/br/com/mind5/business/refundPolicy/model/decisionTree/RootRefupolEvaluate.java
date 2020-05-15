package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.action.LazyRefupolNodeEvaluateL1;
import br.com.mind5.business.refundPolicy.model.action.StdRefupolMergeOrderem;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckEvaluate;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckOrderem;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootRefupolEvaluate extends DeciTreeTemplateWriteV2<RefupolInfo> {
	
	public RootRefupolEvaluate(DeciTreeOption<RefupolInfo> option) {
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
		checker = new RefupolCheckEvaluate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStdV1<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefupolInfo> select = new StdRefupolMergeOrderem(option);
		ActionLazyV1<RefupolInfo> nodeL1 = new LazyRefupolNodeEvaluateL1(option.conn, option.schemaName);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
