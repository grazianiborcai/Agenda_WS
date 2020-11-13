package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceDefaultOn;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeToSelect;
import br.com.mind5.business.storeText.model.action.LazyStorextRootUpdate;
import br.com.mind5.business.storeText.model.action.StdStorextMergeStorextarch;
import br.com.mind5.business.storeText.model.action.StdStorextSuccess;
import br.com.mind5.business.storeText.model.checker.StorextCheckStorextarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextDeleteL3 extends DeciTreeTemplateWriteV2<StorextInfo> {

	public NodeStorextDeleteL3(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StorextCheckStorextarch(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueueV2<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV2<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorextInfo> mergeStorextarch = new StdStorextMergeStorextarch(option);
		ActionLazy<StorextInfo> mergeToSelect = new LazyStorextMergeToSelect(option.conn, option.schemaName);
		ActionLazy<StorextInfo> enforceDefaultOn = new LazyStorextEnforceDefaultOn(option.conn, option.schemaName); 
		ActionLazy<StorextInfo> update = new LazyStorextRootUpdate(option.conn, option.schemaName); 
		
		mergeStorextarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(update);
		
		actions.add(mergeStorextarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV2<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorextInfo> success = new StdStorextSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
