package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.LazyPayordemistRootSelect;
import br.com.mind5.payment.payOrderItemList.model.action.StdPayordemistMergePayormarch;

public final class RootPayordemistSearch extends DeciTreeTemplateWriteV2<PayordemistInfo> {
	
	public RootPayordemistSearch(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemistInfo> buildCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelCheckerV1<PayordemistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemistInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemistInfo> option) {
		List<ActionStdV1<PayordemistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemistInfo> mergePayormarch = new StdPayordemistMergePayormarch(option);
		ActionLazy<PayordemistInfo> select = new LazyPayordemistRootSelect(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(select);
		
		actions.add(mergePayormarch);
		return actions;
	}
}
