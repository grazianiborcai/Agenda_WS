package br.com.mind5.security.tokenAuthentication.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.model.action.LazyTauthMergeUsername;
import br.com.mind5.security.tokenAuthentication.model.action.StdTauthMergeJwtoken;
import br.com.mind5.security.tokenAuthentication.model.action.StdTauthValidateJwtoken;
import br.com.mind5.security.tokenAuthentication.model.checker.TauthCheckRead;

public final class RootTauthToken extends DeciTreeWriteTemplate<TauthInfo> {
	
	public RootTauthToken(DeciTreeOption<TauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TauthInfo> buildDecisionCheckerHook(DeciTreeOption<TauthInfo> option) {
		List<ModelChecker<TauthInfo>> queue = new ArrayList<>();		
		ModelChecker<TauthInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TauthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<TauthInfo>> buildActionsOnPassedHook(DeciTreeOption<TauthInfo> option) {
		List<ActionStd<TauthInfo>> actions = new ArrayList<>();
		
		ActionStd<TauthInfo> validateJwtoken = new StdTauthValidateJwtoken(option);
		ActionStd<TauthInfo> mergeJwtoken = new StdTauthMergeJwtoken(option);
		ActionLazy<TauthInfo> mergeUsername = new LazyTauthMergeUsername(option.conn, option.schemaName);
		
		mergeJwtoken.addPostAction(mergeUsername);
		
		actions.add(validateJwtoken);		
		actions.add(mergeJwtoken);	
		return actions;
	}
}
