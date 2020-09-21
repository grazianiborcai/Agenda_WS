package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceDefaultOff;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceLChanged;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeToSelect;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeUsername;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoUpdate;
import br.com.mind5.business.storeText.model.action.StdMatextMergeMatextault;
import br.com.mind5.business.storeText.model.action.StdStorextSuccess;
import br.com.mind5.business.storeText.model.checker.MatextCheckMatextault;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextDefaultL2 extends DeciTreeTemplateWriteV2<StorextInfo> {
	
	public NodeStorextDefaultL2(DeciTreeOption<StorextInfo> option) {
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
		checker = new MatextCheckMatextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> mergeMatextault = new StdMatextMergeMatextault(option);
		ActionLazyV1<StorextInfo> mergeToSelect = new LazyStorextMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<StorextInfo> enforceLChanged = new LazyStorextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<StorextInfo> enforceLChangedBy = new LazyStorextMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StorextInfo> enforceDefaultOff = new LazyStorextEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazyV1<StorextInfo> update = new LazyStorextDaoUpdate(option.conn, option.schemaName);
		ActionStdV1<StorextInfo> success = new StdStorextSuccess(option);	
		
		mergeMatextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeMatextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();

		ActionStdV1<StorextInfo> success = new StdStorextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
