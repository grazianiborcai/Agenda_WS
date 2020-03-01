package br.com.mind5.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.action.LazyRefuNodeRefund;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckLangu;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckOrder;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckOwner;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckRefund;
import br.com.mind5.payment.refundOrder.model.checker.RefuCheckUsername;

public final class RootRefuRefund extends DeciTreeWriteTemplate<RefuInfo> {
	
	public RootRefuRefund(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuInfo> buildDecisionCheckerHook(DeciTreeOption<RefuInfo> option) {
		List<ModelChecker<RefuInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuCheckRefund(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuCheckOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStd<RefuInfo>> actions = new ArrayList<>();		

		ActionStd<RefuInfo> nodeOrder = new NodeRefuOrder(option).toAction();
		ActionLazy<RefuInfo> nodeRefund = new LazyRefuNodeRefund(option.conn, option.schemaName);
		
		nodeOrder.addPostAction(nodeRefund);
		
		actions.add(nodeOrder);		
		return actions;
	}
}
