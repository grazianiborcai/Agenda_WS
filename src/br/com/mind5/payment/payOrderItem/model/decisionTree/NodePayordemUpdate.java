package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemNodeRefresh;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemUpdate;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemEnforceLChanged;

public final class NodePayordemUpdate extends DeciTreeTemplateWrite<PayordemInfo> {
	
	public NodePayordemUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> enforceLChanged = new StdPayordemEnforceLChanged(option);
		ActionLazy<PayordemInfo> update = new LazyPayordemUpdate(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> refresh = new LazyPayordemNodeRefresh(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(update);
		update.addPostAction(refresh);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
