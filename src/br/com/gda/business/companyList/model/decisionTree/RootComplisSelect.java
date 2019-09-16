package br.com.gda.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.business.companyList.model.action.StdComplisMergeToSelect;
import br.com.gda.business.companyList.model.checker.ComplisCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootComplisSelect extends DeciTreeReadTemplate<ComplisInfo> {
	
	public RootComplisSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComplisInfo> buildDecisionCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelChecker<ComplisInfo>> queue = new ArrayList<>();		
		ModelChecker<ComplisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new ComplisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStd<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStd<ComplisInfo> select = new StdComplisMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}
