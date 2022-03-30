package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.PhoneVisiNodeUpdateT00;
import br.com.mind5.business.phone.model.action.PhoneVisiNodeUpdateT01;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceAreaT01;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceNumberT00;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceNumberT01;
import br.com.mind5.business.phone.model.checker.PhoneCheckFormT01;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhoneNodeUpdate extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public PhoneNodeUpdate(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckFormT01(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<PhoneInfo> enforceNumberT01 = new ActionStdCommom<PhoneInfo>(option, PhoneVisiEnforceNumberT01.class);
		ActionLazy<PhoneInfo> enforceAreaT01 = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceAreaT01.class);
		ActionLazy<PhoneInfo> nodeUpdateT01 = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiNodeUpdateT01.class);
		
		enforceNumberT01.addPostAction(enforceAreaT01);
		enforceAreaT01.addPostAction(nodeUpdateT01);

		actions.add(enforceNumberT01);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> enforceNumberT00 = new ActionStdCommom<PhoneInfo>(option, PhoneVisiEnforceNumberT00.class);
		ActionLazy<PhoneInfo> nodeUpdateT00 = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiNodeUpdateT00.class);
		
		enforceNumberT00.addPostAction(nodeUpdateT00);

		actions.add(enforceNumberT00);		
		return actions;
	}
}
