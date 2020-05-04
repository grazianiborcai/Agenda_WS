package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeUsername;
import br.com.mind5.payment.payOrder.model.action.LazyPayordNodeAuthL2;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToSelect;

public final class NodePayordAuthL1 extends DeciTreeTemplateWriteV2<PayordInfo> {
	
	public NodePayordAuthL1(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV1<PayordInfo>> actions = new ArrayList<>();		

		ActionStdV1<PayordInfo> mergeToSelect = new StdPayordMergeToSelect(option);
		ActionLazyV1<PayordInfo> mergeUsername = new LazyPayordMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<PayordInfo> nodeL2 = new LazyPayordNodeAuthL2(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeL2);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
