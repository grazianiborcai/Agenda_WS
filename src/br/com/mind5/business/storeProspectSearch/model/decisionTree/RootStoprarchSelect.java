package br.com.mind5.business.storeProspectSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.action.StdStoprarchMergeToSelect;
import br.com.mind5.business.storeProspectSearch.model.checker.StoprarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;


public final class RootStoprarchSelect extends DeciTreeTemplateReadV2<StoprarchInfo> {
	
	public RootStoprarchSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoprarchInfo> buildCheckerHook(DeciTreeOption<StoprarchInfo> option) {
		List<ModelCheckerV1<StoprarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoprarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoprarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoprarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprarchInfo> option) {
		List<ActionStdV1<StoprarchInfo>> actions = new ArrayList<>();

		ActionStdV1<StoprarchInfo> select = new StdStoprarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
