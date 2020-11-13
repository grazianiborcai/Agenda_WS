package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapMatextsnapInsert;
import br.com.mind5.business.materialSnapshot.model.action.LazyMatsnapRootSelect;
import br.com.mind5.business.materialSnapshot.model.action.StdMatsnapDaoInsert;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMatsnapInsert extends DeciTreeTemplateWrite<MatsnapInfo> {
	
	public RootMatsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatsnapInfo> buildCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatsnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatsnapCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatsnapInfo> insertMatsnap = new StdMatsnapDaoInsert(option);
		ActionLazy<MatsnapInfo> insertMatextsnap = new LazyMatsnapMatextsnapInsert(option.conn, option.schemaName);	
		ActionLazy<MatsnapInfo> select = new LazyMatsnapRootSelect(option.conn, option.schemaName);	
		
		insertMatsnap.addPostAction(insertMatextsnap);
		insertMatextsnap.addPostAction(select);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
