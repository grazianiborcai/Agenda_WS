package br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StusorageVisiDaoInsert;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StusorageVisiEnforceLChanged;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckExist;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckRead;


public final class StusorageRootInsert extends DeciTreeTemplateWrite<StusorageInfo> {
	
	public StusorageRootInsert(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorageInfo> buildCheckerHook(DeciTreeOption<StusorageInfo> option) {
		List<ModelChecker<StusorageInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorageInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorageCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StusorageCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorageInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorageInfo> option) {
		List<ActionStd<StusorageInfo>> actions = new ArrayList<>();

		ActionStd<StusorageInfo> enforceLChanged = new ActionStdCommom<StusorageInfo>(option, StusorageVisiEnforceLChanged.class);
		ActionLazy<StusorageInfo> insert = new ActionLazyCommom<StusorageInfo>(option, StusorageVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
