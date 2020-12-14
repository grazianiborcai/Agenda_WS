package br.com.mind5.stats.userStorePurchaseStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;
import br.com.mind5.stats.userStorePurchaseStgn.model.action.LazyStusorageDaoUpdate;
import br.com.mind5.stats.userStorePurchaseStgn.model.action.StdStusorageEnforceLChanged;
import br.com.mind5.stats.userStorePurchaseStgn.model.checker.StusorageCheckExist;
import br.com.mind5.stats.userStorePurchaseStgn.model.checker.StusorageCheckRead;


public final class RootStusorageUpdate extends DeciTreeTemplateWrite<StusorageInfo> {
	
	public RootStusorageUpdate(DeciTreeOption<StusorageInfo> option) {
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorageCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorageInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorageInfo> option) {
		List<ActionStd<StusorageInfo>> actions = new ArrayList<>();

		ActionStd<StusorageInfo> enforceLChanged = new StdStusorageEnforceLChanged(option);
		ActionLazy<StusorageInfo> update = new LazyStusorageDaoUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(update);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
