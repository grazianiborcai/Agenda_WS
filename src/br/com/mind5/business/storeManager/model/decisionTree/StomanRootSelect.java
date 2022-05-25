package br.com.mind5.business.storeManager.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.model.action.StomanVisiMergeToSelect;
import br.com.mind5.business.storeManager.model.checker.StomanCheckLangu;
import br.com.mind5.business.storeManager.model.checker.StomanCheckOwner;
import br.com.mind5.business.storeManager.model.checker.StomanCheckRead;
import br.com.mind5.business.storeManager.model.checker.StomanCheckUser;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StomanRootSelect extends DeciTreeTemplateRead<StomanInfo> {
	
	public StomanRootSelect(DeciTreeOption<StomanInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StomanInfo> buildCheckerHook(DeciTreeOption<StomanInfo> option) {
		List<ModelChecker<StomanInfo>> queue = new ArrayList<>();		
		ModelChecker<StomanInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StomanCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StomanInfo>> buildActionsOnPassedHook(DeciTreeOption<StomanInfo> option) {
		List<ActionStd<StomanInfo>> actions = new ArrayList<>();

		ActionStd<StomanInfo> select = new ActionStdCommom<StomanInfo>(option, StomanVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
