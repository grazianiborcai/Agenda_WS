package br.com.mind5.payment.payOrderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.action.StdPayormarchMergeToSelect;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckRead;

public final class RootPayormarchSelect extends DeciTreeWriteTemplate<PayormarchInfo> {
	
	public RootPayormarchSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayormarchInfo> buildDecisionCheckerHook(DeciTreeOption<PayormarchInfo> option) {
		List<ModelChecker<PayormarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayormarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayormarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayormarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayormarchInfo> option) {
		List<ActionStd<PayormarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PayormarchInfo> select = new StdPayormarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
