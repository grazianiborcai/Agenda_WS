package br.com.gda.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneInsert;
import br.com.gda.business.phone.model.checker.PhoneCheckArea;
import br.com.gda.business.phone.model.checker.PhoneCheckLengthT01;
import br.com.gda.business.phone.model.checker.PhoneCheckNumberT01;
import br.com.gda.business.phone.model.checker.PhoneCheckSequenceT01;
import br.com.gda.business.phone.model.checker.PhoneCheckOnlyNumber;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneInsertT01 extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneInsertT01(DeciTreeOption<PhoneInfo> option) {
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
		checker = new PhoneCheckLengthT01(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckArea(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();
		
		ActionStd<PhoneInfo> insert = new StdPhoneInsert(option);	

		
		actions.add(insert);		
		return actions;
	}
}
