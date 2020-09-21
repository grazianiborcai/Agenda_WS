package br.com.mind5.business.storeTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.action.StdStorextarchMergeToSelect;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckOwner;
import br.com.mind5.business.storeTextSearch.model.checker.StorextarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStorextarchSelect extends DeciTreeTemplateReadV2<StorextarchInfo> {
	
	public RootStorextarchSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextarchInfo> buildCheckerHook(DeciTreeOption<StorextarchInfo> option) {
		List<ModelCheckerV1<StorextarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextarchCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextarchCheckOwner(checkerOption);
		queue.add(checker);			
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextarchInfo> option) {
		List<ActionStdV1<StorextarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextarchInfo> select = new StdStorextarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
