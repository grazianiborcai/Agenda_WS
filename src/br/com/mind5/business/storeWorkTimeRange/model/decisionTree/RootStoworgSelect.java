package br.com.mind5.business.storeWorkTimeRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.action.StdStoworgMergeToSelect;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckLangu;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckOwner;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckRead;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStoworgSelect extends DeciTreeTemplateRead<StoworgInfo> {
	
	public RootStoworgSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoworgInfo> buildCheckerHook(DeciTreeOption<StoworgInfo> option) {
		List<ModelCheckerV1<StoworgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoworgInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoworgCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoworgInfo>> buildActionsOnPassedHook(DeciTreeOption<StoworgInfo> option) {
		List<ActionStdV1<StoworgInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoworgInfo> mergeToSelect = new StdStoworgMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
