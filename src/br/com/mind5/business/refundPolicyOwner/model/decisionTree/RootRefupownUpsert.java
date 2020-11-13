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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootRefupownUpsert extends DeciTreeTemplateWriteV2<RefupownInfo> {
	
	public RootRefupownUpsert(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupownInfo> buildCheckerHook(DeciTreeOption<RefupownInfo> option) {
		List<ModelCheckerV1<RefupownInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupownInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefupownInfo> enforceLChanged = new StdRefupownEnforceLChanged(option);	
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
