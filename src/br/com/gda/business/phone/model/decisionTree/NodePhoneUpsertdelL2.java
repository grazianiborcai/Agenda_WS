package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.LazyPhoneNodeUpsertdelL3;
import br.com.gda.business.phone.model.action.LazyPhoneRootInsert;
import br.com.gda.business.phone.model.action.StdPhoneFilterNew;
import br.com.gda.business.phone.model.action.StdPhoneFilterOld;
import br.com.gda.business.phone.model.checker.PhoneCheckNewRecord;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneUpsertdelL2 extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneUpsertdelL2(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		final boolean ONLY_OLD_RECORD = false;
		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ONLY_OLD_RECORD;	
		checker = new PhoneCheckNewRecord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> nodeL3 = new NodePhoneUpsertdelL3(option).toAction();
		
		actions.add(nodeL3);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> filterOld = new StdPhoneFilterOld(option);			
		ActionLazy<PhoneInfo> nodeL3 = new LazyPhoneNodeUpsertdelL3(option.conn, option.schemaName);
		ActionStd<PhoneInfo> filterNew = new StdPhoneFilterNew(option);			
		ActionLazy<PhoneInfo> insert = new LazyPhoneRootInsert(option.conn, option.schemaName);
		
		filterOld.addPostAction(nodeL3);
		filterNew.addPostAction(insert);
		
		actions.add(filterOld);		
		actions.add(filterNew);	
		return actions;
	}
}
