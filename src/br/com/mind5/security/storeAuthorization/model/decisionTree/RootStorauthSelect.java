package br.com.mind5.security.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.action.LazyStorauthNodeSelectL1;
import br.com.mind5.security.storeAuthorization.model.action.StdStorauthMergeUsername;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckOwner;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckRead;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckStore;

public final class RootStorauthSelect extends DeciTreeWriteTemplate<StorauthInfo> {
	
	public RootStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorauthInfo> buildDecisionCheckerHook(DeciTreeOption<StorauthInfo> option) {	
		List<ModelChecker<StorauthInfo>> queue = new ArrayList<>();		
		ModelChecker<StorauthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StorauthCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorauthCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorauthCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStd<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStd<StorauthInfo> mergeUsername = new StdStorauthMergeUsername(option);	
		ActionLazy<StorauthInfo> nodeSelectL1 = new LazyStorauthNodeSelectL1(option.conn, option.schemaName);	
		
		mergeUsername.addPostAction(nodeSelectL1);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
