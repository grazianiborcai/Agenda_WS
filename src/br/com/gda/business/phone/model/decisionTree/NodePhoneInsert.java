package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneEnforceAreaT01;
import br.com.gda.business.phone.model.action.LazyPhoneNodeInsertT00;
import br.com.gda.business.phone.model.action.LazyPhoneNodeInsertT01;
import br.com.gda.business.phone.model.action.StdPhoneEnforceNumberT00;
import br.com.gda.business.phone.model.action.StdPhoneEnforceNumberT01;
import br.com.gda.business.phone.model.checker.PhoneCheckFormT01;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneInsert extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneInsert(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	

		checker = new PhoneCheckFormT01();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> enforceNumberT01 = new StdPhoneEnforceNumberT01(option);
		ActionLazy<PhoneInfo> enforceAreaT01 = new LazyPhoneEnforceAreaT01(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> nodeInsertT01 = new LazyPhoneNodeInsertT01(option.conn, option.schemaName);
		
		enforceNumberT01.addPostAction(enforceAreaT01);
		enforceAreaT01.addPostAction(nodeInsertT01);

		actions.add(enforceNumberT01);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();

		ActionStd<PhoneInfo> enforceNumberT00 = new StdPhoneEnforceNumberT00(option);
		ActionLazy<PhoneInfo> nodeInsertT00 = new LazyPhoneNodeInsertT00(option.conn, option.schemaName);
		
		enforceNumberT00.addPostAction(nodeInsertT00);

		actions.add(enforceNumberT00);		
		return actions;
	}
}
