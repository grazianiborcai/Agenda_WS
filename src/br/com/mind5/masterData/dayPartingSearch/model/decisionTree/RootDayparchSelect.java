package br.com.mind5.masterData.dayPartingSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.masterData.dayPartingSearch.model.action.StdDayparchDaoSelect;
import br.com.mind5.masterData.dayPartingSearch.model.checker.DayparchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootDayparchSelect extends DeciTreeTemplateReadV2<DayparchInfo> {
	
	public RootDayparchSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<DayparchInfo> buildCheckerHook(DeciTreeOption<DayparchInfo> option) {
		List<ModelCheckerV1<DayparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<DayparchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new DayparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<DayparchInfo>> buildActionsOnPassedHook(DeciTreeOption<DayparchInfo> option) {
		List<ActionStdV2<DayparchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<DayparchInfo> select = new StdDayparchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
