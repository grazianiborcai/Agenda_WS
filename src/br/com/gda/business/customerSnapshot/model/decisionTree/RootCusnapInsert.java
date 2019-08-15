package br.com.gda.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.business.customerSnapshot.model.action.LazyCusnapInsert;
import br.com.gda.business.customerSnapshot.model.action.StdCusnapMergePerson;
import br.com.gda.business.customerSnapshot.model.checker.CusnapCheckLangu;
import br.com.gda.business.customerSnapshot.model.checker.CusnapCheckOwner;
import br.com.gda.business.customerSnapshot.model.checker.CusnapCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusnapInsert extends DeciTreeWriteTemplate<CusnapInfo> {

	public RootCusnapInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusnapInfo> buildDecisionCheckerHook(DeciTreeOption<CusnapInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CusnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> mergePerson = new StdCusnapMergePerson(option);
		ActionLazy<CusnapInfo> insert = new LazyCusnapInsert(option.conn, option.schemaName);
		
		mergePerson.addPostAction(insert);
		
		actions.add(mergePerson);	
		return actions;
	}
}
