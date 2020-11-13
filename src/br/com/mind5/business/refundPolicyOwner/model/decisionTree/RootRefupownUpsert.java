package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownEnforceCreatedBy;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownEnforceCreatedOn;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownMergeUsername;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownNodeUpsert;
import br.com.mind5.business.refundPolicyOwner.model.action.LazyRefupownRootSelect;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownEnforceLChanged;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckOwner;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckRefugroup;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootRefupownUpsert extends DeciTreeTemplateWrite<RefupownInfo> {
	
	public RootRefupownUpsert(DeciTreeOption<RefupownInfo> option) {
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
		
		ActionStd<RefupownInfo> enforceLChanged = new StdRefupownEnforceLChanged(option);	
		ActionLazy<RefupownInfo> enforceLChangedBy = new LazyRefupownMergeUsername(option.conn, option.schemaName);		
		ActionLazy<RefupownInfo> enforceCreatedBy = new LazyRefupownEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<RefupownInfo> enforceCreatedOn = new LazyRefupownEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<RefupownInfo> upsert = new LazyRefupownNodeUpsert(option.conn, option.schemaName);
		ActionLazy<RefupownInfo> select = new LazyRefupownRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(upsert);
		upsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
