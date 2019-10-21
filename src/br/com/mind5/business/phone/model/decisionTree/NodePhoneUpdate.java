package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneEnforceAreaT01;
import br.com.mind5.business.phone.model.action.LazyPhoneNodeUpdateT00;
import br.com.mind5.business.phone.model.action.LazyPhoneNodeUpdateT01;
import br.com.mind5.business.phone.model.action.StdPhoneEnforceNumberT00;
import br.com.mind5.business.phone.model.action.StdPhoneEnforceNumberT01;
import br.com.mind5.business.phone.model.checker.PhoneCheckFormT01;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneUpdate extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneUpdate(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckFormT01(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<PhoneInfo> enforceNumberT01 = new StdPhoneEnforceNumberT01(option);
		ActionLazy<PhoneInfo> enforceAreaT01 = new LazyPhoneEnforceAreaT01(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> nodeUpdateT01 = new LazyPhoneNodeUpdateT01(option.conn, option.schemaName);
		
		enforceNumberT01.addPostAction(enforceAreaT01);
		enforceAreaT01.addPostAction(nodeUpdateT01);

		actions.add(enforceNumberT01);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> enforceNumberT00 = new StdPhoneEnforceNumberT00(option);
		ActionLazy<PhoneInfo> nodeUpdateT00 = new LazyPhoneNodeUpdateT00(option.conn, option.schemaName);
		
		enforceNumberT00.addPostAction(nodeUpdateT00);

		actions.add(enforceNumberT00);		
		return actions;
	}
}
