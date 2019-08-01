package br.com.gda.payment.refundOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrder.model.action.LazyRefuRefund;
import br.com.gda.payment.refundOrder.model.action.StdRefuMergePayord;
import br.com.gda.payment.refundOrder.model.checker.RefuCheckLangu;
import br.com.gda.payment.refundOrder.model.checker.RefuCheckOwner;
import br.com.gda.payment.refundOrder.model.checker.RefuCheckPayord;
import br.com.gda.payment.refundOrder.model.checker.RefuCheckRefund;
import br.com.gda.payment.refundOrder.model.checker.RefuCheckUsername;

public final class RootRefuRefund extends DeciTreeWriteTemplate<RefuInfo> {
	
	public RootRefuRefund(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuInfo> buildDecisionCheckerHook(DeciTreeOption<RefuInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<RefuInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new RefuCheckRefund();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefuCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefuCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefuCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefuCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuInfo> option) {
		List<ActionStd<RefuInfo>> actions = new ArrayList<>();		

		ActionStd<RefuInfo> mergePayord = new StdRefuMergePayord(option);
		ActionLazy<RefuInfo> refund = new LazyRefuRefund(option.conn, option.schemaName);
		
		mergePayord.addPostAction(refund);
		
		actions.add(mergePayord);		
		return actions;
	}
}
