package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.LazyCusnapInsert;
import br.com.mind5.business.customerSnapshot.model.action.LazyCusnapMergeUselis;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapMergePerson;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckLangu;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckOwner;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusnapInsert extends DeciTreeWriteTemplate<CusnapInfo> {

	public RootCusnapInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusnapInfo> buildDecisionCheckerHook(DeciTreeOption<CusnapInfo> option) {	
		List<ModelChecker<CusnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CusnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStdV1<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusnapInfo> mergePerson = new StdCusnapMergePerson(option);
		ActionLazyV1<CusnapInfo> mergeUselis = new LazyCusnapMergeUselis(option.conn, option.schemaName);
		ActionLazyV1<CusnapInfo> insert = new LazyCusnapInsert(option.conn, option.schemaName);
		
		mergePerson.addPostAction(mergeUselis);
		mergeUselis.addPostAction(insert);
		
		actions.add(mergePerson);	
		return actions;
	}
}
