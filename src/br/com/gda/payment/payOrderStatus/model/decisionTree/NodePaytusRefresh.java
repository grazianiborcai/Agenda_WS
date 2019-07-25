package br.com.gda.payment.payOrderStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusMergeCuspar;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusMergePaytusem;
import br.com.gda.payment.payOrderStatus.model.action.StdPaytusMergePayord;
import br.com.gda.payment.payOrderStatus.model.checker.PaytusCheckLangu;
import br.com.gda.payment.payOrderStatus.model.checker.PaytusCheckSelect;

public final class NodePaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public NodePaytusRefresh(DeciTreeOption<PaytusInfo> option) {
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

		ActionStd<PaytusInfo> select = new RootPaytusSelect(option).toAction();	
		ActionLazy<PaytusInfo> mergeCuspar = new LazyPaytusMergeCuspar(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> mergePaytusem = new LazyPaytusMergePaytusem(option.conn, option.schemaName);	
		
		select.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergePaytusem);
		
		actions.add(select);		
		return actions;
	}
}
