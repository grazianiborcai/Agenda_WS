package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapEnforceStorextsnapKey;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorextsnapInsert;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergeStorext;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapSuccess;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckStorextarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorapStorextsnap extends DeciTreeTemplateWriteV2<StorapInfo> {
	
	public NodeStorapStorextsnap(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {		
		List<ModelCheckerV1<StorapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorapInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckStorextarch(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStdV1<StorapInfo>> actions = new ArrayList<>();

		ActionStdV1<StorapInfo> mergeStorext = new StdStorapMergeStorext(option);
		ActionLazyV1<StorapInfo> enforceStorextsnapKey = new LazyStorapEnforceStorextsnapKey(option.conn, option.schemaName);
		ActionLazyV1<StorapInfo> insertStorextsnap = new LazyStorextsnapInsert(option.conn, option.schemaName);
		
		mergeStorext.addPostAction(enforceStorextsnapKey);
		enforceStorextsnapKey.addPostAction(insertStorextsnap);
		
		actions.add(mergeStorext);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStdV1<StorapInfo>> actions = new ArrayList<>();

		ActionStdV1<StorapInfo> success = new StdStorapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
