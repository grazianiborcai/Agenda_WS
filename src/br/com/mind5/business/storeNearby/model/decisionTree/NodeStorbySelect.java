package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckReadDistrict;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeStorbySelect extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public NodeStorbySelect(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorbyCheckReadDistrict(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> selectName = new RootStorbySelectDistrict(option).toAction();
		
		actions.add(selectName);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnFailedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> selectGeo = new RootStorbySelectGeo(option).toAction();
		
		actions.add(selectGeo);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
