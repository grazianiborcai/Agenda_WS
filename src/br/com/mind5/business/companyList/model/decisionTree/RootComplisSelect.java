package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.StdComplisMergeToSelect;
import br.com.mind5.business.companyList.model.checker.ComplisCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
	
	
	
	@Override protected List<ActionStdV1<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStdV1<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ComplisInfo> select = new StdComplisMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}
