package br.com.mind5.business.phoneSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.LazyPhonapInsert;
import br.com.mind5.business.phoneSnapshot.model.action.LazyPhonapRootSelect;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckOwner;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPhonapInsert extends DeciTreeWriteTemplate<PhonapInfo> {
	
	public RootPhonapInsert(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonapInfo> buildCheckerHook(DeciTreeOption<PhonapInfo> option) {
		List<ModelChecker<PhonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonapInfo> option) {
		List<ActionStdV1<PhonapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<PhonapInfo> nodeUser = new NodePhonapUselis(option).toAction();	
		ActionLazyV1<PhonapInfo> insert = new LazyPhonapInsert(option.conn, option.schemaName);		
		ActionLazyV1<PhonapInfo> select = new LazyPhonapRootSelect(option.conn, option.schemaName);	
		
		nodeUser.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeUser);	
		return actions;
	}
}
