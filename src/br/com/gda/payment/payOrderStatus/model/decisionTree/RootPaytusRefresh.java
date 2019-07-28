package br.com.gda.payment.payOrderStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusMergeCuspar;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusNodeRefresh;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusPaytusemRefresh;
import br.com.gda.payment.payOrderStatus.model.checker.PaytusCheckOwner;
import br.com.gda.payment.payOrderStatus.model.checker.PaytusCheckRefresh;

public final class RootPaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public RootPaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaytusCheckRefresh();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> selectToRefresh = new RootPaytusSelect(option).toAction();	
		ActionLazy<PaytusInfo> mergeCuspar = new LazyPaytusMergeCuspar(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> nodeRefresh = new LazyPaytusNodeRefresh(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> paytusemRefresh = new LazyPaytusPaytusemRefresh(option.conn, option.schemaName);		
		ActionStd<PaytusInfo> selectOutput = new RootPaytusSelect(option).toAction();	
		
		selectToRefresh.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(nodeRefresh);
		mergeCuspar.addPostAction(paytusemRefresh);
		
		actions.add(selectToRefresh);		
		actions.add(selectOutput);
		return actions;
	}
}
