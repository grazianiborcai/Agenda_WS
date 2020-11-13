package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeStolis;
import br.com.mind5.business.storeWorkTime.model.action.LazyStowotmMergeWeekday;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmMergeToSelect;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckLangu;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckOwner;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckRead;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStowotmSelect extends DeciTreeTemplateReadV2<StowotmInfo> {
	
	public RootStowotmSelect(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelCheckerV1<StowotmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StowotmInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStdV1<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StowotmInfo> mergeToSelect = new StdStowotmMergeToSelect(option);
		ActionLazy<StowotmInfo> mergeStolis = new LazyStowotmMergeStolis(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> mergeWeekday = new LazyStowotmMergeWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeStolis);	
		mergeStolis.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
