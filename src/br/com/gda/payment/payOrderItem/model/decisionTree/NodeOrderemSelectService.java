package br.com.gda.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemEnforceWeekday;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemMergeEmplis;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemMergeMatore;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemMergeWeekday;
import br.com.gda.payment.payOrderItem.model.action.StdOrderemMergeStolis;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckIsService;

public final class NodeOrderemSelectService extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public NodeOrderemSelectService(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;
		
		checker = new OrderemCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> mergeStolis = new StdOrderemMergeStolis(option);
		ActionLazy<PayordemInfo> mergeEmplis = new LazyOrderemMergeEmplis(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> enforceWeekday = new LazyOrderemEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> mergeWeekday = new LazyOrderemMergeWeekday(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> mergeMatore = new LazyOrderemMergeMatore(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMatore);
		
		actions.add(mergeStolis);
		return actions;
	}
}
