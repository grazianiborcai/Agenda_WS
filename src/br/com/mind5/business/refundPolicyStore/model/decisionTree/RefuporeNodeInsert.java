package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiDaoInsert;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiDaoUpdate;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckSoftDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefuporeNodeInsert extends DeciTreeTemplateWrite<RefuporeInfo> {
	
	public RefuporeNodeInsert(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelChecker<RefuporeInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuporeInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporeCheckSoftDelete(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefuporeInfo> update = new ActionStdCommom<RefuporeInfo>(option, RefuporeVisiDaoUpdate.class);	
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnFailedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefuporeInfo> insert = new ActionStdCommom<RefuporeInfo>(option, RefuporeVisiDaoInsert.class);	
		
		actions.add(insert);
		return actions;
	}
}
