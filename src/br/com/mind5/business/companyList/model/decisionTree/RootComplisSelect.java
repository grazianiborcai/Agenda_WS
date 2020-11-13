package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.StdComplisMergeToSelect;
import br.com.mind5.business.companyList.model.checker.ComplisCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootComplisSelect extends DeciTreeTemplateReadV2<ComplisInfo> {
	
	public RootComplisSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<ComplisInfo> buildCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelCheckerV1<ComplisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<ComplisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new ComplisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStdV2<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<ComplisInfo> select = new StdComplisMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}
