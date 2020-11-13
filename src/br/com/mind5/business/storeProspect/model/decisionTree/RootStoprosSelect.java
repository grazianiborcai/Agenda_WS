package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosCheckSysotup;
import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosMergeProstus;
import br.com.mind5.business.storeProspect.model.action.StdStoprosMergeToSelect;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckExist;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;


public final class RootStoprosSelect extends DeciTreeTemplateReadV2<StoprosInfo> {
	
	public RootStoprosSelect(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelCheckerV1<StoprosInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoprosInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoprosCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckSysotup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoprosCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStdV1<StoprosInfo>> actions = new ArrayList<>();

		ActionStdV1<StoprosInfo> select = new StdStoprosMergeToSelect(option);
		ActionLazy<StoprosInfo> mergeProstus = new LazyStoprosMergeProstus(option.conn, option.schemaName);
		
		select.addPostAction(mergeProstus);
		
		actions.add(select);
		return actions;
	}
}
