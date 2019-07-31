package br.com.gda.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.action.LazyPaytusEnforceOrderStatus;
import br.com.gda.payment.statusPayOrder.model.action.LazyPaytusMergePaytusem;
import br.com.gda.payment.statusPayOrder.model.action.StdPaytusMergePayord;
import br.com.gda.payment.statusPayOrder.model.checker.PaytusCheckLangu;
import br.com.gda.payment.statusPayOrder.model.checker.PaytusCheckSelect;

public final class RootPaytusSelect extends DeciTreeReadTemplate<PaytusInfo> {
	
	public RootPaytusSelect(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaytusCheckSelect();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> mergePayord = new StdPaytusMergePayord(option);	
		ActionLazy<PaytusInfo> mergePaytusem = new LazyPaytusMergePaytusem(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> enforceOrderStatus = new LazyPaytusEnforceOrderStatus(option.conn, option.schemaName);
		
		mergePayord.addPostAction(mergePaytusem);
		mergePaytusem.addPostAction(enforceOrderStatus);
		
		actions.add(mergePayord);		
		return actions;
	}
}
