package br.com.gda.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.gda.payment.statusPayOrderItem.model.action.StdPaytusemMergePayordem;
import br.com.gda.payment.statusPayOrderItem.model.checker.PaytusemCheckLangu;
import br.com.gda.payment.statusPayOrderItem.model.checker.PaytusemCheckRead;

public final class RootPaytusemSelect extends DeciTreeReadTemplate<PaytusemInfo> {
	
	public RootPaytusemSelect(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaytusemCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusemCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> mergePayordem = new StdPaytusemMergePayordem(option);	
		
		actions.add(mergePayordem);		
		return actions;
	}
}
