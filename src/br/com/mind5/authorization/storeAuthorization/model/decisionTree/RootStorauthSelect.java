package br.com.mind5.authorization.storeAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.action.LazyStorauthNodeSelectL1;
import br.com.mind5.authorization.storeAuthorization.model.action.StdStorauthMergeUsername;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckOwner;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckReadSelect;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStorauthSelect extends DeciTreeTemplateWriteV2<StorauthInfo> {
	
	public RootStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorauthInfo> buildCheckerHook(DeciTreeOption<StorauthInfo> option) {	
		List<ModelCheckerV1<StorauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorauthInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorauthInfo>> buildActionsOnPassedHook(DeciTreeOption<StorauthInfo> option) {
		List<ActionStdV1<StorauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorauthInfo> mergeUsername = new StdStorauthMergeUsername(option);	
		ActionLazyV1<StorauthInfo> nodeL1 = new LazyStorauthNodeSelectL1(option.conn, option.schemaName);	
		
		mergeUsername.addPostAction(nodeL1);
		
		actions.add(mergeUsername);		
		return actions;
	}
}
