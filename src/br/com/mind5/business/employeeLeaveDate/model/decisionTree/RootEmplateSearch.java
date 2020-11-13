package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateRootSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateMergeEmplarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public class RootEmplateSearch extends DeciTreeTemplateReadV2<EmplateInfo> {
	
	public RootEmplateSearch(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmplateInfo> buildCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelCheckerV1<EmplateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmplateInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStdV2<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStdV2<EmplateInfo> mergeEmplarch = new StdEmplateMergeEmplarch(option);
		ActionLazy<EmplateInfo> select = new LazyEmplateRootSelect(option.conn, option.schemaName);
		
		mergeEmplarch.addPostAction(select);
		
		actions.add(mergeEmplarch);
		return actions;
	}
}
