package br.com.mind5.authorization.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.action.StorauthVisiNodeSelectL1;
import br.com.mind5.authorization.storeAuthorization.model.action.StorauthVisiMergeUsername;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckOwner;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckReadSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStorauthSelect extends DeciTreeTemplateWrite<StorauthInfo> {
	
	public RootStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildCheckerHook(DeciTreeOption<StorauthInfo> option) {	
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StorauthCheckReadSelect(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorauthCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> mergeUsername = new ActionStdCommom<StorauthInfo>(option, StorauthVisiMergeUsername.class);	
		ActionLazy<StorauthInfo> nodeL1 = new ActionLazyCommom<StorauthInfo>(option, StorauthVisiNodeSelectL1.class);	
		
		mergeUsername.addPostAction(nodeL1);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
