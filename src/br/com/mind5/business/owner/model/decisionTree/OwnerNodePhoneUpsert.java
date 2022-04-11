package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforcePhoneKey;
import br.com.mind5.business.owner.model.action.OwnerVisiPhoneUpsert;
import br.com.mind5.business.owner.model.checker.OwnerCheckHasPhone;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerNodePhoneUpsert extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public OwnerNodePhoneUpsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OwnerCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforcePhoneKey = new ActionStdCommom<OwnerInfo>(option, OwnerVisiEnforcePhoneKey.class);
		ActionLazy<OwnerInfo> upsertPhone = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiPhoneUpsert.class);	
		
		enforcePhoneKey.addPostAction(upsertPhone);
		
		actions.add(enforcePhoneKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnFailedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> sucess = new ActionStdSuccessCommom<OwnerInfo>(option);
		
		actions.add(sucess);		
		return actions;
	}
}
