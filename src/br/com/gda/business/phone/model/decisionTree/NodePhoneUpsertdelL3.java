package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneRootDelete;
import br.com.gda.business.phone.model.action.StdPhoneFilterDeleted;
import br.com.gda.business.phone.model.checker.PhoneCheckFlagDel;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneUpsertdelL3 extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneUpsertdelL3(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		final boolean ONLY_NON_DELETED_RECORD = false;
		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ONLY_NON_DELETED_RECORD;	
		checker = new PhoneCheckFlagDel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> update = new RootPhoneUpdate(option).toAction();
		
		actions.add(update);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> update = new RootPhoneUpdate(option).toAction();
		ActionStd<PhoneInfo> filterDel = new StdPhoneFilterDeleted(option);			
		ActionLazy<PhoneInfo> delete = new LazyPhoneRootDelete(option.conn, option.schemaName);
		
		filterDel.addPostAction(delete);
		
		actions.add(update);		
		actions.add(filterDel);	
		
		return actions;
	}
}
