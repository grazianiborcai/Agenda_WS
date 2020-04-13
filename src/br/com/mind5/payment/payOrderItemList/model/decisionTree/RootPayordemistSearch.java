package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.LazyPayordemistRootSelect;
import br.com.mind5.payment.payOrderItemList.model.action.StdPayordemistMergePayormarch;
import br.com.mind5.payment.payOrderItemList.model.checker.PayordemistCheckDummy;

public final class RootPayordemistSearch extends DeciTreeTemplateWriteV1<PayordemistInfo> {
	
	public RootPayordemistSearch(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemistInfo> buildCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelCheckerV1<PayordemistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemistInfo> checker;	

		checker = new PayordemistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordemistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemistInfo> option) {
		List<ActionStdV1<PayordemistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayordemistInfo> mergePayormarch = new StdPayordemistMergePayormarch(option);
		ActionLazyV1<PayordemistInfo> select = new LazyPayordemistRootSelect(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(select);
		
		actions.add(mergePayormarch);
		return actions;
	}
}
