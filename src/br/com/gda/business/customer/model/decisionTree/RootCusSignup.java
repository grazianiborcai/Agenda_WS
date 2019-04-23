package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.checker.CusCheckTechField;
import br.com.gda.business.customer.model.checker.CusCheckOwner;
import br.com.gda.business.customer.model.checker.CusCheckSignup;
import br.com.gda.business.customer.model.checker.CusCheckLangu;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusSignup extends DeciTreeWriteTemplate<CusInfo> {

	public RootCusSignup(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusCheckSignup();
		queue.add(checker);
		
		checker = new CusCheckTechField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> nodeSignupL1 = new NodeCusSignupL1(option).toAction();
		
		actions.add(nodeSignupL1);	
		return actions;
	}
}
