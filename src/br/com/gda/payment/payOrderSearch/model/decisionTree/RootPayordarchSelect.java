package br.com.gda.payment.payOrderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.model.action.StdPayordarchMergeToSelect;
import br.com.gda.payment.payOrderSearch.model.checker.PayordarchCheckLangu;
import br.com.gda.payment.payOrderSearch.model.checker.PayordarchCheckOwner;
import br.com.gda.payment.payOrderSearch.model.checker.PayordarchCheckRead;

public final class RootPayordarchSelect extends DeciTreeReadTemplate<PayordarchInfo> {
	
	public RootPayordarchSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordarchInfo> buildDecisionCheckerHook(DeciTreeOption<PayordarchInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayordarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PayordarchCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PayordarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordarchInfo> option) {
		List<ActionStd<PayordarchInfo>> actions = new ArrayList<>();		

		ActionStd<PayordarchInfo> mergeToSelect = new StdPayordarchMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
