package br.com.mind5.masterData.dayParting.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.action.LazyDaypartRootSelect;
import br.com.mind5.masterData.dayParting.model.action.StdDaypartMergeDayparch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootDaypartSearch extends DeciTreeTemplateWriteV2<DaypartInfo> {
	
	public RootDaypartSearch(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<DaypartInfo> buildCheckerHook(DeciTreeOption<DaypartInfo> option) {
		List<ModelCheckerV1<DaypartInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<DaypartInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<DaypartInfo>> buildActionsOnPassedHook(DeciTreeOption<DaypartInfo> option) {
		List<ActionStdV1<DaypartInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<DaypartInfo> mergeDayparch = new StdDaypartMergeDayparch(option);		
		ActionLazyV1<DaypartInfo> select = new LazyDaypartRootSelect(option.conn, option.schemaName);
		
		mergeDayparch.addPostAction(select);
		
		actions.add(mergeDayparch);			
		return actions;
	}
}
