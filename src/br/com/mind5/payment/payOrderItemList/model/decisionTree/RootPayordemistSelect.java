package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.StdPayordemistMergeToSelect;
import br.com.mind5.payment.payOrderItemList.model.checker.PayordemistCheckRead;

public final class RootPayordemistSelect extends DeciTreeWriteTemplate<PayordemistInfo> {
	
	public RootPayordemistSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemistInfo> buildDecisionCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelChecker<PayordemistInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemistCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemistInfo> option) {
		List<ActionStd<PayordemistInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemistInfo> select = new StdPayordemistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
