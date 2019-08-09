package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneUpdate;
import br.com.gda.business.phone.model.checker.PhoneCheckArea;
import br.com.gda.business.phone.model.checker.PhoneCheckLengthT01;
import br.com.gda.business.phone.model.checker.PhoneCheckNumberT01;
import br.com.gda.business.phone.model.checker.PhoneCheckOnlyNumber;
import br.com.gda.business.phone.model.checker.PhoneCheckSequenceT01;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneUpdateT01 extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneUpdateT01(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;

		checker = new PhoneCheckLengthT01();
		queue.add(checker);
		
		checker = new PhoneCheckOnlyNumber();
		queue.add(checker);
		
		checker = new PhoneCheckSequenceT01();
		queue.add(checker);
		
		checker = new PhoneCheckNumberT01();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PhoneCheckArea(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<PhoneInfo> update = new StdPhoneUpdate(option);	
		
		actions.add(update);		
		return actions;
	}
}
