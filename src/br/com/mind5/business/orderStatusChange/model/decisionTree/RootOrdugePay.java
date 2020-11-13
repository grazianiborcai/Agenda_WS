package br.com.mind5.business.orderStatusChange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.action.StdOrdugeEnforceWaiting;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckPay;
import br.com.mind5.business.orderStatusChange.model.checker.OrdugeCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrdugePay extends DeciTreeTemplateRead<OrdugeInfo> {
	
	public RootOrdugePay(DeciTreeOption<OrdugeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdugeInfo> buildCheckerHook(DeciTreeOption<OrdugeInfo> option) {
		List<ModelChecker<OrdugeInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdugeInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdugeCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdugeCheckPay(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdugeInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdugeInfo> option) {
		List<ActionStd<OrdugeInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdugeInfo> enforceStatus = new StdOrdugeEnforceWaiting(option);
		
		actions.add(enforceStatus);			
		return actions;
	}
}
