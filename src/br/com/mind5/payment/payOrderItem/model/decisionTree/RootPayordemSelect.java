package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemNodeSelectL1;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemMergeToSelect;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckRead;

public final class RootPayordemSelect extends DeciTreeTemplateWriteV2<PayordemInfo> {
	
	public RootPayordemSelect(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelCheckerV1<PayordemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV1<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemInfo> select = new StdPayordemMergeToSelect(option);
		ActionLazyV1<PayordemInfo> nodeL1 = new LazyPayordemNodeSelectL1(option.conn, option.schemaName);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
