package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.LazyPayordemistRootSelect;
import br.com.mind5.payment.payOrderItemList.model.action.StdPayordemistMergePayormarch;

public final class RootPayordemistSearch extends DeciTreeTemplateWrite<PayordemistInfo> {
	
	public RootPayordemistSearch(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemistInfo> buildCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelChecker<PayordemistInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemistInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemistInfo> option) {
		List<ActionStd<PayordemistInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemistInfo> mergePayormarch = new StdPayordemistMergePayormarch(option);
		ActionLazy<PayordemistInfo> select = new LazyPayordemistRootSelect(option.conn, option.schemaName);
		
		mergePayormarch.addPostAction(select);
		
		actions.add(mergePayormarch);
		return actions;
	}
}
