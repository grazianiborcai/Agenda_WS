package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapEnforceStorextsnapKey;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorextsnapInsert;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergeStorext;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapSuccess;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckStorextarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorapStorextsnap extends DeciTreeTemplateWrite<StorapInfo> {
	
	public NodeStorapStorextsnap(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {		
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckStorextarch(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> mergeStorext = new StdStorapMergeStorext(option);
		ActionLazy<StorapInfo> enforceStorextsnapKey = new LazyStorapEnforceStorextsnapKey(option.conn, option.schemaName);
		ActionLazy<StorapInfo> insertStorextsnap = new LazyStorextsnapInsert(option.conn, option.schemaName);
		
		mergeStorext.addPostAction(enforceStorextsnapKey);
		enforceStorextsnapKey.addPostAction(insertStorextsnap);
		
		actions.add(mergeStorext);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> success = new StdStorapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
