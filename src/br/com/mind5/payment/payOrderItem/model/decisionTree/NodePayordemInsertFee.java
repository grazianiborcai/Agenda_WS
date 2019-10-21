package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemInsert;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemEnforceSysReceiver;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckFeeCateg;

public final class NodePayordemInsertFee extends DeciTreeWriteTemplate<PayordemInfo> {
	
	public NodePayordemInsertFee(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordemInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordemCheckFeeCateg(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStd<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemInfo> enforceSysReceiver = new StdPayordemEnforceSysReceiver(option);
		ActionLazy<PayordemInfo> insert = new LazyPayordemInsert(option.conn, option.schemaName);
		
		enforceSysReceiver.addPostAction(insert);
		
		actions.add(enforceSysReceiver);
		return actions;
	}
}
