package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.LazyPayordemistRootSelect;
import br.com.mind5.payment.payOrderItemList.model.action.StdPayordemistMergePayormarch;
import br.com.mind5.payment.payOrderItemList.model.checker.PayordemistCheckDummy;

public final class RootPayordemistSearch extends DeciTreeWriteTemplate<PayordemistInfo> {
	
	public RootPayordemistSearch(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemistInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelChecker<PayordemistInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemistInfo> checker;	

		checker = new PayordemistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
