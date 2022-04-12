package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiNodeUpsert;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiRootSelectFallback;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiEnforceCreatedBy;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiEnforceCreatedOn;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiEnforceLChanged;
import br.com.mind5.business.refundPolicyOwner.model.action.RefupownVisiMergeUsername;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckOwner;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckRefugroup;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RefupownRootUpsert extends DeciTreeTemplateWrite<RefupownInfo> {
	
	public RefupownRootUpsert(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefupownInfo> buildCheckerHook(DeciTreeOption<RefupownInfo> option) {
		List<ModelChecker<RefupownInfo>> queue = new ArrayList<>();		
		ModelChecker<RefupownInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupownCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefupownCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefupownCheckRefugroup(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStd<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStd<RefupownInfo> enforceLChanged = new ActionStdCommom<RefupownInfo>(option, RefupownVisiEnforceLChanged.class);	
		ActionLazy<RefupownInfo> enforceLChangedBy = new ActionLazyCommom<RefupownInfo>(option, RefupownVisiMergeUsername.class);		
		ActionLazy<RefupownInfo> enforceCreatedBy = new ActionLazyCommom<RefupownInfo>(option, RefupownVisiEnforceCreatedBy.class);	
		ActionLazy<RefupownInfo> enforceCreatedOn = new ActionLazyCommom<RefupownInfo>(option, RefupownVisiEnforceCreatedOn.class);
		ActionLazy<RefupownInfo> upsert = new ActionLazyCommom<RefupownInfo>(option, RefupownVisiNodeUpsert.class);
		ActionLazy<RefupownInfo> select = new ActionLazyCommom<RefupownInfo>(option, RefupownVisiRootSelectFallback.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(upsert);
		upsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
