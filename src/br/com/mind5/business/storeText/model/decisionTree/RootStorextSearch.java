package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextRootSelect;
import br.com.mind5.business.storeText.model.action.StdStorextMergeStorextarch;
import br.com.mind5.business.storeText.model.checker.StorextCheckStore;
import br.com.mind5.business.storeText.model.checker.StorextCheckOwner;
import br.com.mind5.business.storeText.model.checker.StorextCheckSearch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStorextSearch extends DeciTreeTemplateWriteV2<StorextInfo> {
	
	public RootStorextSearch(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextCheckSearch(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorextCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorextCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> mergeStorextarch = new StdStorextMergeStorextarch(option);
		ActionLazyV1<StorextInfo> select = new LazyStorextRootSelect(option.conn, option.schemaName);
		
		mergeStorextarch.addPostAction(select);
		
		actions.add(mergeStorextarch);
		return actions;
	}
}