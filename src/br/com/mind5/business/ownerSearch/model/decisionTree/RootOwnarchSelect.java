package br.com.mind5.business.ownerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.action.StdOwnarchMergeToSelect;
import br.com.mind5.business.ownerSearch.model.checker.OwnarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOwnarchSelect extends DeciTreeTemplateReadV2<OwnarchInfo> {

	public RootOwnarchSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnarchInfo> buildCheckerHook(DeciTreeOption<OwnarchInfo> option) {
		List<ModelCheckerV1<OwnarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OwnarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnarchInfo> option) {
		List<ActionStdV2<OwnarchInfo>> actions = new ArrayList<>();

		ActionStdV2<OwnarchInfo> select = new StdOwnarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
	