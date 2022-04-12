package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiNodeUpsert;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiRootSelect;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiEnforceCreatedBy;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiEnforceCreatedOn;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiEnforceLChanged;
import br.com.mind5.business.refundPolicyStore.model.action.RefuporeVisiMergeUsername;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckOwner;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckRefugroup;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckStorauth;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckStore;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefuporeRootUpsert extends DeciTreeTemplateWrite<RefuporeInfo> {
	
	public RefuporeRootUpsert(DeciTreeOption<RefuporeInfo> option) {
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
		
		ActionStd<RefuporeInfo> enforceLChanged = new ActionStdCommom<RefuporeInfo>(option, RefuporeVisiEnforceLChanged.class);	
		ActionLazy<RefuporeInfo> enforceLChangedBy = new ActionLazyCommom<RefuporeInfo>(option, RefuporeVisiMergeUsername.class);		
		ActionLazy<RefuporeInfo> enforceCreatedBy = new ActionLazyCommom<RefuporeInfo>(option, RefuporeVisiEnforceCreatedBy.class);	
		ActionLazy<RefuporeInfo> enforceCreatedOn = new ActionLazyCommom<RefuporeInfo>(option, RefuporeVisiEnforceCreatedOn.class);
		ActionLazy<RefuporeInfo> upsert = new ActionLazyCommom<RefuporeInfo>(option, RefuporeVisiNodeUpsert.class);
		ActionLazy<RefuporeInfo> select = new ActionLazyCommom<RefuporeInfo>(option, RefuporeVisiRootSelect.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(upsert);
		upsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
