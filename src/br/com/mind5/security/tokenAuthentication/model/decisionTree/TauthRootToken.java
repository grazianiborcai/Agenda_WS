package br.com.mind5.security.tokenAuthentication.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.model.action.TauthVisiMergeJwtoken;
import br.com.mind5.security.tokenAuthentication.model.action.TauthVisiMergeUsername;
import br.com.mind5.security.tokenAuthentication.model.action.TauthVisiValidateJwtoken;
import br.com.mind5.security.tokenAuthentication.model.checker.TauthCheckRead;

public final class TauthRootToken extends DeciTreeTemplateWrite<TauthInfo> {
	
	public TauthRootToken(DeciTreeOption<TauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TauthInfo> buildCheckerHook(DeciTreeOption<TauthInfo> option) {
		List<ModelChecker<TauthInfo>> queue = new ArrayList<>();		
		ModelChecker<TauthInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TauthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<TauthInfo>> buildActionsOnPassedHook(DeciTreeOption<TauthInfo> option) {
		List<ActionStd<TauthInfo>> actions = new ArrayList<>();
		
		ActionStd<TauthInfo> validateJwtoken = new ActionStdCommom<TauthInfo>(option, TauthVisiValidateJwtoken.class);
		ActionStd<TauthInfo> mergeJwtoken = new ActionStdCommom<TauthInfo>(option, TauthVisiMergeJwtoken.class);
		ActionLazy<TauthInfo> mergeUsername = new ActionLazyCommom<TauthInfo>(option, TauthVisiMergeUsername.class);
		
		mergeJwtoken.addPostAction(mergeUsername);
		
		actions.add(validateJwtoken);		
		actions.add(mergeJwtoken);	
		return actions;
	}
}
