package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiRootSelectUser;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiEnforceUsernameKey;
import br.com.mind5.business.customerSearch.model.action.CusarchVisiMergeUsername;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckHasUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusarchRootSelectUsername extends DeciTreeTemplateRead<CusarchInfo> {
	
	public CusarchRootSelectUsername(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelChecker<CusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusarchCheckHasUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStd<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CusarchInfo> enforceUsernameKey = new ActionStdCommom<CusarchInfo>(option, CusarchVisiEnforceUsernameKey.class);
		ActionLazy<CusarchInfo> mergeUsername = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiMergeUsername.class);
		ActionLazy<CusarchInfo> select = new ActionLazyCommom<CusarchInfo>(option, CusarchVisiRootSelectUser.class);
		
		enforceUsernameKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(select);
		
		actions.add(enforceUsernameKey);
		return actions;
	}
}
