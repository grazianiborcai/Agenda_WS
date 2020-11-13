package br.com.mind5.business.storeWorkTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.action.StdStowotarchMergeToSelect;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckLangu;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckOwner;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckRead;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckStore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStowotarchSelect extends DeciTreeTemplateReadV2<StowotarchInfo> {
	
	public RootStowotarchSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StowotarchInfo> buildCheckerHook(DeciTreeOption<StowotarchInfo> option) {
		List<ModelCheckerV1<StowotarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StowotarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotarchCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StowotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotarchInfo> option) {
		List<ActionStdV2<StowotarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StowotarchInfo> select = new StdStowotarchMergeToSelect(option);
		
		actions.add(select);		
		return actions; 
	}
}
