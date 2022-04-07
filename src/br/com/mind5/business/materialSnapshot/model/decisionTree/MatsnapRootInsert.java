package br.com.mind5.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiRootSelect;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiDaoInsert;
import br.com.mind5.business.materialSnapshot.model.action.MatsnapVisiMatextsnapInsert;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckMat;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckOwner;
import br.com.mind5.business.materialSnapshot.model.checker.MatsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatsnapRootInsert extends DeciTreeTemplateWrite<MatsnapInfo> {
	
	public MatsnapRootInsert(DeciTreeOption<MatsnapInfo> option) {
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
		
		ActionStd<MatsnapInfo> insertMatsnap = new ActionStdCommom<MatsnapInfo>(option, MatsnapVisiDaoInsert.class);
		ActionLazy<MatsnapInfo> insertMatextsnap = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiMatextsnapInsert.class);	
		ActionLazy<MatsnapInfo> select = new ActionLazyCommom<MatsnapInfo>(option, MatsnapVisiRootSelect.class);	
		
		insertMatsnap.addPostAction(insertMatextsnap);
		insertMatextsnap.addPostAction(select);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
