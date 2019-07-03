package br.com.gda.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemMergeMatsnap;
import br.com.gda.payment.payOrderItem.model.action.LazyOrderemNodeSelect;
import br.com.gda.payment.payOrderItem.model.action.StdOrderemMergeToSelect;
import br.com.gda.payment.payOrderItem.model.checker.OrderemCheckRead;

public final class RootOrderemSelect extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public RootOrderemSelect(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;
		
		checker = new OrderemCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> select = new StdOrderemMergeToSelect(option);
		ActionLazy<PayordemInfo> mergeMatsnap = new LazyOrderemMergeMatsnap(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> nodeSelect = new LazyOrderemNodeSelect(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMatsnap);
		mergeMatsnap.addPostAction(nodeSelect);
		
		actions.add(select);
		return actions;
	}
}
