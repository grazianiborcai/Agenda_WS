package br.com.mind5.authorization.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.action.StorauthVisiMergeToSelect;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthDaemon;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StorauthNodeAuthorizationL3 extends DeciTreeTemplateWrite<StorauthInfo> {
	
	public StorauthNodeAuthorizationL3(DeciTreeOption<StorauthInfo> option) {
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
		checker = new StorauthCheckAuthDaemon(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> success = new ActionStdSuccessCommom<StorauthInfo>(option);		
		actions.add(success);		
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnFailedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> select = new ActionStdCommom<StorauthInfo>(option, StorauthVisiMergeToSelect.class);
			
		actions.add(select);		
		return actions;
	}
}
