package br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.action.SytotauhVisiMergeStorauth;
import br.com.mind5.authorization.storePartitionAuthorization.model.checker.SytotauhCheckAuthManager;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SytotauhNodeSelectL4 extends DeciTreeTemplateWrite<SytotauhInfo> {
	
	public SytotauhNodeSelectL4(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SytotauhInfo> buildCheckerHook(DeciTreeOption<SytotauhInfo> option) {
		List<ModelChecker<SytotauhInfo>> queue = new ArrayList<>();		
		ModelChecker<SytotauhInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;			
		checker = new SytotauhCheckAuthManager(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SytotauhInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotauhInfo> option) {
		List<ActionStd<SytotauhInfo>> actions = new ArrayList<>();
		
		ActionStd<SytotauhInfo> mergeStorauth = new ActionStdCommom<SytotauhInfo>(option, SytotauhVisiMergeStorauth.class);
		
		actions.add(mergeStorauth);
		return actions;
	}
	
	
	

	
	
	
	@Override protected List<ActionStd<SytotauhInfo>> buildActionsOnFailedHook(DeciTreeOption<SytotauhInfo> option) {
		List<ActionStd<SytotauhInfo>> actions = new ArrayList<>();
		
		ActionStd<SytotauhInfo> nodeL5 = new SytotauhNodeSelectL5(option).toAction();
		
		actions.add(nodeL5);
		return actions;
	}
}
