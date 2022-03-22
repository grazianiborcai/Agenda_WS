package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.CuslisVisiMergeFimist;
import br.com.mind5.business.customerList.model.action.CuslisVisiMergePersolis;
import br.com.mind5.business.customerList.model.action.CuslisVisiMergeToSelect;
import br.com.mind5.business.customerList.model.checker.CuslisCheckLangu;
import br.com.mind5.business.customerList.model.checker.CuslisCheckOwner;
import br.com.mind5.business.customerList.model.checker.CuslisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CuslisRootSelect extends DeciTreeTemplateRead<CuslisInfo> {
	
	public CuslisRootSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CuslisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CuslisCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CuslisCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStd<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStd<CuslisInfo> select = new ActionStdCommom<CuslisInfo>(option, CuslisVisiMergeToSelect.class);
		ActionLazy<CuslisInfo> mergePersolis = new ActionLazyCommom<CuslisInfo>(option, CuslisVisiMergePersolis.class);
		ActionLazy<CuslisInfo> mergeFimist = new ActionLazyCommom<CuslisInfo>(option, CuslisVisiMergeFimist.class);
		
		select.addPostAction(mergePersolis);
		mergePersolis.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
