package br.com.mind5.business.storeTextDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextDefault.model.action.StdStorextaultMergeToSelect;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckStore;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckOwner;
import br.com.mind5.business.storeTextDefault.model.checker.StorextaultCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStorextaultSelect extends DeciTreeTemplateReadV2<StorextaultInfo> {
	
	public RootStorextaultSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextaultInfo> buildCheckerHook(DeciTreeOption<StorextaultInfo> option) {
		List<ModelCheckerV1<StorextaultInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextaultInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextaultCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorextaultInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextaultInfo> option) {
		List<ActionStdV2<StorextaultInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorextaultInfo> select = new StdStorextaultMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
