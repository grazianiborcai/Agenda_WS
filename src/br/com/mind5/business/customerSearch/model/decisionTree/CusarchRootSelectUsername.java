package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchMergeUsername;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchRootSelectUser;
import br.com.mind5.business.customerSearch.model.action.StdCusarchEnforceUsernameKey;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckHasUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCusarchSelectUsername extends DeciTreeTemplateRead<CusarchInfo> {
	
	public RootCusarchSelectUsername(DeciTreeOption<CusarchInfo> option) {
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
		
		ActionStd<CusarchInfo> enforceUsernameKey = new StdCusarchEnforceUsernameKey(option);
		ActionLazy<CusarchInfo> mergeUsername = new LazyCusarchMergeUsername(option.conn, option.schemaName);
		ActionLazy<CusarchInfo> select = new LazyCusarchRootSelectUser(option.conn, option.schemaName);
		
		enforceUsernameKey.addPostAction(mergeUsername);
		mergeUsername.addPostAction(select);
		
		actions.add(enforceUsernameKey);
		return actions;
	}
}
