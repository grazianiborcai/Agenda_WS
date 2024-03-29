package br.com.mind5.file.sysFileImageSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.model.action.FimgysapVisiRootSelect;
import br.com.mind5.file.sysFileImageSnapshot.model.action.FimgysapVisiDaoInsert;
import br.com.mind5.file.sysFileImageSnapshot.model.checker.FimgysapCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgysapRootInsert extends DeciTreeTemplateWrite<FimgysapInfo> {
	
	public FimgysapRootInsert(DeciTreeOption<FimgysapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysapInfo> buildCheckerHook(DeciTreeOption<FimgysapInfo> option) {
		List<ModelChecker<FimgysapInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysapCheckInsert(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysapInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysapInfo> option) {
		List<ActionStd<FimgysapInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgysapInfo> insert = new ActionStdCommom<FimgysapInfo>(option, FimgysapVisiDaoInsert.class);
		ActionLazy<FimgysapInfo> select = new ActionLazyCommom<FimgysapInfo>(option, FimgysapVisiRootSelect.class);
		
		insert.addPostAction(select);

		actions.add(insert);		
		return actions;
	}
}
