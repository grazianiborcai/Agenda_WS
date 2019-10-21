package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapRootSelect;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapInsert;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatsnapInsert extends DeciTreeWriteTemplate<MatsnapInfo> {
	
	public RootMatsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatsnapInfo> buildDecisionCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatsnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatsnapInfo> insert = new StdMatsnapInsert(option);	
		ActionLazy<MatsnapInfo> select = new LazyMatsnapRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(select);
		
		actions.add(insert);
		return actions;
	}
}
