package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.LazyPaytusemNodeRefresh;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckOwner;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckRefresh;

public final class RootPaytusemRefresh extends DeciTreeWriteTemplate<PaytusemInfo> {
	
	public RootPaytusemRefresh(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaytusemCheckRefresh();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusemCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> select = new RootPaytusemSelect(option).toAction();	
		ActionLazy<PaytusemInfo> nodeRefresh = new LazyPaytusemNodeRefresh(option.conn, option.schemaName);
		
		select.addPostAction(nodeRefresh);
		
		actions.add(select);		
		return actions;
	}
}
