package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.StdComplisMergeToSelect;
import br.com.mind5.business.companyList.model.checker.ComplisCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootComplisSelect extends DeciTreeTemplateRead<ComplisInfo> {
	
	public RootComplisSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComplisInfo> buildCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelChecker<ComplisInfo>> queue = new ArrayList<>();		
		ModelChecker<ComplisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new ComplisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStd<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStd<ComplisInfo> select = new StdComplisMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}
