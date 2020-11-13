package br.com.mind5.business.storeFavoriteSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeFavoriteSearch.model.action.StdStoritarchMergeToSelect;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckLangu;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckOwner;
import br.com.mind5.business.storeFavoriteSearch.model.checker.StoritarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoritarchSelect extends DeciTreeTemplateWriteV2<StoritarchInfo> {
	
	public RootStoritarchSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoritarchInfo> buildCheckerHook(DeciTreeOption<StoritarchInfo> option) {
		List<ModelCheckerV1<StoritarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoritarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoritarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoritarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoritarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StoritarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoritarchInfo> option) {
		List<ActionStdV2<StoritarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StoritarchInfo> select = new StdStoritarchMergeToSelect(option);
		
		actions.add(select);	
		return actions;
	}
}
