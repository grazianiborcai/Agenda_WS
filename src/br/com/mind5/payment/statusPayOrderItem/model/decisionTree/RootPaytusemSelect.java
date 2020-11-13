package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemMergePayordem;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckLangu;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckRead;

public final class RootPaytusemSelect extends DeciTreeTemplateRead<PaytusemInfo> {
	
	public RootPaytusemSelect(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusemInfo> buildCheckerHook(DeciTreeOption<PaytusemInfo> option) {
		List<ModelChecker<PaytusemInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusemCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PaytusemCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStd<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusemInfo> mergePayordem = new StdPaytusemMergePayordem(option);	
		
		actions.add(mergePayordem);		
		return actions;
	}
}
