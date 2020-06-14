package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosDaoUpdate;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosEnforceLChanged;
import br.com.mind5.business.storeProspect.model.action.StdStoprosMergeToUpdate;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckExist;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckLangu;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckOwner;
import br.com.mind5.business.storeProspect.model.checker.StoprosCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoprosUpdate extends DeciTreeTemplateWriteV2<StoprosInfo> {
	
	public RootStoprosUpdate(DeciTreeOption<StoprosInfo> option) {
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
		checker = new StoprosCheckWrite(checkerOption);
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
		checker = new StoprosCheckOwner(checkerOption);
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

		ActionStdV1<StoprosInfo> mergeToUpdate = new StdStoprosMergeToUpdate(option);
		ActionLazyV1<StoprosInfo> enforceLChanged = new LazyStoprosEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<StoprosInfo> update = new LazyStoprosDaoUpdate(option.conn, option.schemaName);
			
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
