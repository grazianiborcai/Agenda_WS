package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeEnforceCreatedBy;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeEnforceCreatedOn;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeMergeUsername;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeNodeUpsert;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeRootSelect;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeEnforceLChanged;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckOwner;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckRefugroup;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckStorauth;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckStore;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootRefuporeUpsert extends DeciTreeTemplateWrite<RefuporeInfo> {
	
	public RootRefuporeUpsert(DeciTreeOption<RefuporeInfo> option) {
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
		checker = new RefuporeCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuporeCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuporeCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuporeCheckRefugroup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefuporeCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefuporeInfo> enforceLChanged = new StdRefuporeEnforceLChanged(option);	
		ActionLazy<RefuporeInfo> enforceLChangedBy = new LazyRefuporeMergeUsername(option.conn, option.schemaName);		
		ActionLazy<RefuporeInfo> enforceCreatedBy = new LazyRefuporeEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<RefuporeInfo> enforceCreatedOn = new LazyRefuporeEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<RefuporeInfo> upsert = new LazyRefuporeNodeUpsert(option.conn, option.schemaName);
		ActionLazy<RefuporeInfo> select = new LazyRefuporeRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(upsert);
		upsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
