package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiEnforceStorextsnapKey;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiMergeStorext;
import br.com.mind5.business.storeSnapshot.model.action.StorapVisiStorextsnapInsert;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckStorextarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StorapNodeStorextsnap extends DeciTreeTemplateWrite<StorapInfo> {
	
	public StorapNodeStorextsnap(DeciTreeOption<StorapInfo> option) {
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

		ActionStd<StorapInfo> mergeStorext = new ActionStdCommom<StorapInfo>(option, StorapVisiMergeStorext.class);
		ActionLazy<StorapInfo> enforceStorextsnapKey = new ActionLazyCommom<StorapInfo>(option, StorapVisiEnforceStorextsnapKey.class);
		ActionLazy<StorapInfo> insertStorextsnap = new ActionLazyCommom<StorapInfo>(option, StorapVisiStorextsnapInsert.class);
		
		mergeStorext.addPostAction(enforceStorextsnapKey);
		enforceStorextsnapKey.addPostAction(insertStorextsnap);
		
		actions.add(mergeStorext);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();
		
		ActionStd<StorapInfo> sucess = new ActionStdSuccessCommom<StorapInfo>(option);		
		
		actions.add(sucess);		
		return actions;
	}
}
